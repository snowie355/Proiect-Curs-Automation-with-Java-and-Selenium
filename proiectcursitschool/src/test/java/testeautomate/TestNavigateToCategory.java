package testeautomate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import reutilizabile.BasicWebDriver;

public class TestNavigateToCategory extends BasicWebDriver {

    @Test(priority = 10) // Prioritate diferită de testele de login
    public void testNavigateToCategory() throws InterruptedException {
        // Așteaptă să dispară orice overlay care poate bloca interacțiunea
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'ui dimmer') and contains(@class, 'active')]")));

        if (driver.findElements(By.className("dimmer")).size() > 0) {
            System.out.println("Overlay prezent. Aștept să dispară...");
            Thread.sleep(500);
        }
        

        // Localizează și apasă pe butonul "Produse"
        
        WebElement produseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Produse']")));
        actions.moveToElement(produseButton).perform();
        wait.until(ExpectedConditions.visibilityOf(produseButton)); 
        produseButton.click();

        // Așteaptă încărcarea meniului de produse
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class, 'ProductsMenu')]")));

        WebElement telefoaneTableteButton;
        try {
            telefoaneTableteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class, 'ProductsMenu')]//a[@title='Telefoane, Tablete']")));
        } catch (Exception e) {
            telefoaneTableteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Telefoane, Tablete']")));
        }
        actions.moveToElement(telefoaneTableteButton).perform();
        wait.until(ExpectedConditions.elementToBeClickable(telefoaneTableteButton)).click();

        // Așteaptă încărcarea subcategoriei "Telefoane"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class, 'ProductsMenu-categoriiList')]//a[@title='Telefoane']")));

        WebElement telefoaneButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class, 'ProductsMenu-categoriiList')]//a[@title='Telefoane']")));
        actions.moveToElement(telefoaneButton).perform();
        wait.until(ExpectedConditions.elementToBeClickable(telefoaneButton)).click();

        // Verifică dacă URL-ul conține "/telefoane"
        wait.until(ExpectedConditions.urlContains("/telefoane"));

        String currentUrl = driver.getCurrentUrl();
        System.out.println("URL curent: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("/telefoane"), "Eroare: URL-ul nu este cel așteptat!");
    }
}
