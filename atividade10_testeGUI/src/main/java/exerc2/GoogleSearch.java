import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GoogleSearch {
    public static void main(String[] args) {
        // Configuração do WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bueno\\OneDrive\\Documentos\\apps\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Acessar o Google
        driver.get("https://www.google.com.br");

        // Localizar o campo de pesquisa
        WebElement searchBox = driver.findElement(By.name("q"));

        // Criar uma instância da classe Actions
        Actions actions = new Actions(driver);

        // Digitar o nome "Ufscar Sorocaba" no campo de pesquisa, letra por letra
        String searchTerm = "Ufscar Sorocaba";
        for (char c : searchTerm.toCharArray()) {
            actions.sendKeys(searchBox, Character.toString(c)).pause(200).perform();
        }

        // Enviar o formulário de pesquisa
        actions.sendKeys(searchBox, Keys.RETURN).perform();

        // Fechar o navegador
        driver.quit();
    }
}
