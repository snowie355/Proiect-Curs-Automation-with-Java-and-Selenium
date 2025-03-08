package reutilizabile;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/*import org.testng.annotations.AfterSuite;*/
import org.testng.annotations.BeforeSuite;

public class BasicWebDriver {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions actions;

   

    @BeforeSuite
    public void setup() {
        if (driver == null) { // Verifică dacă WebDriver nu este deja inițializat
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("start-maximized");
            options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36");
            options.addArguments("--disable-blink-features=AutomationControlled");
           /*  options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
             options.setExperimentalOption("useAutomationExtension", false);*/

            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            actions = new Actions(driver);

            System.out.println("Deschiderea browser-ului Chrome...");

            driver.manage().deleteAllCookies();
            System.out.println("Ștergerea cookie-urilor...");

            driver.get("https://altex.ro/");

            try {
                WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")));
                acceptCookiesButton.click();
            } catch (Exception e) {
                System.out.println("Fereastra pentru cookie-uri nu a fost afișată.");
            }
        }
    }


   /*  @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Închide browserul doar la finalul suitei de teste
            driver = null;
            System.out.println("Browser Chrome închis după toate testele.");
        }
    }
        */
}








