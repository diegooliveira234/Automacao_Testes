
//import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class driver{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\webdrivers\\chromedriver\\128\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // cria o elemento e manda esperar até estar visivel, o botão de login da shoppe precisou
        //WebElement  cmpEnviar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div/div/div/div[2]/div/div[2]/form/button")));
        driver.get("https://www.saucedemo.com");

        //Pagina de Login
        WebElement cmpUserName = driver.findElement(By.id("user-name"));
        cmpUserName.sendKeys("visual_user");
        WebElement cmpPassword = driver.findElement(By.id("password"));
        cmpPassword.sendKeys("secret_sauce");
        WebElement btnLogin = driver.findElement(By.id("login-button"));
        btnLogin.click();

        //Pagina Principal
        WebElement btnAddCartPrimeiroProduto = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        btnAddCartPrimeiroProduto.click();
        WebElement btnCarrinho = driver.findElement(By.id("shopping_cart_container"));
        WebElement iconeCarrinho = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
        int qtdCarrinho = Integer.parseInt((iconeCarrinho.getText()));
        //Adicionei o produto ao carrinho e vou para pagina de finalização da compra
        if (qtdCarrinho>=1){
            btnCarrinho.click();
            WebElement btnCheckout = driver.findElement(By.id("checkout"));
            btnCheckout.click();
        }else {
            System.out.println("Carrinho Vazio");
        }
        // Pagina de compra do produto
        WebElement cmpFirstName = driver.findElement(By.id("first-name"));
        WebElement cmpLastName = driver.findElement(By.id("last-name"));
        WebElement cmpPostalCode = driver.findElement(By.id("postal-code"));
        WebElement btnContinue = driver.findElement(By.id("continue"));
        cmpFirstName.sendKeys("João");
        cmpLastName.sendKeys("da Silva");
        cmpPostalCode.sendKeys("123456789");
        btnContinue.click();
        //Pagina de finalização da compra
        WebElement btnFinish = driver.findElement(By.id("finish"));
        btnFinish.click();
        //Página de Obrigado pela compra
        WebElement txtObrigado = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2"));
        System.out.println(txtObrigado.getText());
        WebElement btnVoltarHome = driver.findElement(By.id("back-to-products"));
        btnVoltarHome.click();
        // De volta a home, e vamos sair da plataforma
        WebElement btnMenu = driver.findElement(By.id("react-burger-menu-btn"));
        btnMenu.click();
        //WebElement btnLogout = driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));

        WebElement btnLogout = driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(btnLogout).doubleClick(btnLogout);

        driver.quit();


    }
}
