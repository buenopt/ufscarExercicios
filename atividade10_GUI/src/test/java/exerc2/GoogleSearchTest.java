package exerc2;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearchTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Configuração do WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bueno\\OneDrive\\Documentos\\apps\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Execução em modo headless (sem exibição de interface gráfica)
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void tearDown() {
        // Fechar o navegador após cada teste
        driver.quit();
    }

    @Test
    public void testGoogleSearch() {
        // Acessar o Google
        driver.get("https://www.google.com.br");

        // Localizar o campo de pesquisa
        WebElement searchBox = driver.findElement(By.name("q"));

        // Digitar o termo de pesquisa
        searchBox.sendKeys("Ufscar Sorocaba");

        // Enviar o formulário de pesquisa
        searchBox.sendKeys(Keys.RETURN);

        // Verificar o título da página de resultados
        String pageTitle = driver.getTitle();
        Assertions.assertTrue(pageTitle.contains("Ufscar Sorocaba"));
    }
}
