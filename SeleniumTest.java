package Configure;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions; 
public class SeleniumTest {

	public static void main(String[] args) {
		// Defina o caminho do WebDriver
		System.setProperty("driver.chrome", "C:\\workspace-curso-java\\Automacao_Testes\\chromedriver.exe");
		// Inicialize o WebDriver
        WebDriver driver =  new ChromeDriver();
     // Navegue para uma página
        driver.get("https://www.google.com");
     // Imprima o título da página
        System.out.println("Título da página: " + driver.getTitle());
     // Feche o navegador
        driver.quit();
	}

}
