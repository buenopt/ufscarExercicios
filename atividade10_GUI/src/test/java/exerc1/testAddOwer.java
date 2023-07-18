package exerc1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PetClinicTest {

    @Test
    public void testAddOwner() {
        // cria nova instancia webdrive
        WebDriver driver = new ChromeDriver();

        // inicia o petclinic
        driver.get("http://localhost:8080/petclinic/");

        // clica no link "Owners"
        HomePage homepage = new HomePage(driver);
        homepage.clickOnOwnersLink();

        // Clica no link "Add Owner"
        OwnersPage ownersPage = new OwnersPage(driver);
        ownersPage.clickOnAddOwnerLink();

        // Preencha o formulário de proprietário
        OwnerDetailsPage ownerDetailsPage = new OwnerDetailsPage(driver);
        ownerDetailsPage.setFirstName("Fernando");
        ownerDetailsPage.setLastName("Bueno");
        ownerDetailsPage.setAddress("Rua Brasil, 123");
        ownerDetailsPage.setCity("Sorocaba");
        ownerDetailsPage.setState("SP");
        ownerDetailsPage.setZipCode("18045470");
        ownerDetailsPage.setPhoneNumber("1598765432");
        ownerDetailsPage.setEmailAddress("buenopt@hotmail.com");

        // Clique no botão "Save"
        ownerDetailsPage.clickOnSaveButton();

        // Verifique se o proprietário foi adicionado com sucesso
        WebElement successMessage = driver.findElement(By.cssSelector(".alert.alert-success"));
        Assertions.assertEquals("Owner added successfully", successMessage.getText());

        // Feche a instância do WebDriver
        driver.quit();
    }
}
