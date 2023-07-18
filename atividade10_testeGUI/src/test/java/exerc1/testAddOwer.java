import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.andreendo.petclinicpageobjects.HomePage;
import com.github.andreendo.petclinicpageobjects.OwnersPage;
import com.github.andreendo.petclinicpageobjects.OwnerDetailsPage;

public class PetClinicTest {

    @Test
    public void testAddOwner() {
        // Create a new WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to the PetClinic home page
        driver.get("http://localhost:8080/petclinic/");

        // Click on the "Owners" link
        HomePage homepage = new HomePage(driver);
        homepage.clickOnOwnersLink();

        // Click on the "Add Owner" link
        OwnersPage ownersPage = new OwnersPage(driver);
        ownersPage.clickOnAddOwnerLink();

        // Fill out the owner form
        OwnerDetailsPage ownerDetailsPage = new OwnerDetailsPage(driver);
        ownerDetailsPage.setFirstName("Fernando");
        ownerDetailsPage.setLastName("Bueno");
        ownerDetailsPage.setAddress("Rua Brasil, 123");
        ownerDetailsPage.setCity("Sorocaba");
        ownerDetailsPage.setState("SP");
        ownerDetailsPage.setZipCode("18045470");
        ownerDetailsPage.setPhoneNumber("1598765432");
        ownerDetailsPage.setEmailAddress("buenopt@hotmail.com");

        // Click on the "Save" button
        ownerDetailsPage.clickOnSaveButton();

        // Verify that the owner was added successfully
        WebElement successMessage = driver.findElement(By.cssSelector(".alert.alert-success"));
        Assertions.assertEquals("Owner added successfully", successMessage.getText());

        // Close the WebDriver instance
        driver.quit();
    }
}
