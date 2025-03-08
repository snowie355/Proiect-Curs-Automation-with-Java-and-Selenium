package testeautomate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
/*import org.openqa.selenium.support.ui.Select;*/
import org.testng.annotations.Test;
import reutilizabile.BasicWebDriver;

public class FinishOrder extends BasicWebDriver {

    @Test(priority = 15, dependsOnMethods = "testAddFirstProductToCart")
    public void testProceedToNextStep() throws InterruptedException {
      

// Așteaptă ca butonul să fie vizibil și clickabil
WebElement nextStepButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.cssSelector("body > div.styles_CartLayout_main_withStickyFooter__ygkBl > div > div.styles_CartWithProducts__FtOh2 > div.styles_CartWithProducts_container_right__L0FmV > div > a > button")));

// Apasă pe buton
nextStepButton.click();
wait.until(ExpectedConditions.urlContains("detalii-comanda"));


        // Selectează "Livrare în magazin"
        WebElement storePickupButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("body > div.styles_CartLayout_main_withStickyFooter__ygkBl > div > div.styles_OrderDetailsPage__vWaqC > div > div.styles_OrderDetailsPage_content_left__Fk08i > div > div:nth-child(1) > div.styles_Shipping_container__A8uZQ > div:nth-child(3) > button")));
        storePickupButton.click();

        // Selectează regiunea "București"
        WebElement regionDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#modal-root > div > div > div > div.styles_ModalBody__RgW6f > div > div > div.styles_SelectWrapper___5EoK > select")));
        regionDropdown.click();
        Thread.sleep(1000);
        WebElement bucharestOption1 = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#modal-root > div > div > div > div.styles_ModalBody__RgW6f > div > div:nth-child(1) > div.styles_SelectWrapper___5EoK > select > option:nth-child(11)")));
        bucharestOption1.click();
        Thread.sleep(1000);

        // Selectează magazinul
        WebElement storeSelectButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#modal-root > div > div > div > div.styles_ModalBody__RgW6f > div > div:nth-child(3) > div.mt-4 > button")));
        storeSelectButton.click();
        Thread.sleep(1000);


    }
}
