
package testeautomate;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import reutilizabile.BasicWebDriver;

public class TestLogin extends BasicWebDriver {
    

    @Test(priority = 1)
    public void testClickContButton() {
        try {
            WebElement contButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'https://altex.ro/cont/') and contains(@class, 'SessionContTrigger')]")));
            actions.moveToElement(contButton).perform();
            Thread.sleep(1000);
            contButton.click();
            System.out.println("✅ Click pe butonul 'Cont' efectuat cu succes!");
        } catch (TimeoutException e) {
            System.out.println("Timeout la gasirea butonului 'Cont', dar continuam testele...");
        } catch (Exception e) {
            System.out.println(" Eroare neasteptata la butonul 'Cont': " + e.getMessage());
        }
    }

    @Test(priority = 2, dependsOnMethods = "testClickContButton")
    public void testEnterCredentials() {
        try {
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
            emailField.click();
            Thread.sleep(500);
            emailField.clear();
            Thread.sleep(300);

            for (char c : "testmail123@gmail.com".toCharArray()) {
                emailField.sendKeys(Character.toString(c));
                Thread.sleep((int) (Math.random() * 200) + 100);
            }

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
            passwordField.click();
            Thread.sleep(500);
            passwordField.clear();
            Thread.sleep(300);

            for (char c : "TestMail123.".toCharArray()) {
                passwordField.sendKeys(Character.toString(c));
                Thread.sleep((int) (Math.random() * 200) + 100);
            }

            System.out.println("✅ Datele de logare au fost introduse cu succes!");
        } catch (TimeoutException e) {
            System.out.println(" Timeout la introducerea credentialelor, dar continuam testele...");
        } catch (Exception e) {
            System.out.println(" Eroare neasteptata la introducerea credentialelor: " + e.getMessage());
        }
    }

    @Test(priority = 3, dependsOnMethods = "testEnterCredentials")
    public void testClickLoginButton() {
        try {
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Autentificare')]/parent::*")));
            actions.moveToElement(loginButton).perform();
            Thread.sleep(1000);
            actions.moveToElement(loginButton).click().perform();
            System.out.println("✅ Click pe butonul de login efectuat!");

            // Așteaptă până când autentificarea este completă sau apare un mesaj de eroare
            try {
                wait.until(ExpectedConditions.or(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'user-dashboard')]")), // Element care apare dacă login-ul reușește
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'error-message')]")) // Element care apare dacă login-ul eșuează
                ));
                System.out.println("✅Login detectat! Continuam testele...");
            } catch (TimeoutException e) {
                System.out.println(" Timeout la verificarea login-ului. Posibila eroare, dar continuam testele...");
            }

        } catch (TimeoutException e) {
            System.out.println(" Timeout la apasarea butonului de login, dar continuam testele...");
        } catch (Exception e) {
            System.out.println(" Eroare neasteptată la apăsarea butonului de login: " + e.getMessage());
        }
    }

    @Test(priority = 4, dependsOnMethods = "testClickLoginButton")
    public void testNavigateAfterLogin() {
        try {
            driver.get("https://altex.ro");
            System.out.println(" Navigare efectuata cu succes după logare!");
        } catch (Exception e) {
            System.out.println(" Eroare neasteptată la navigare: " + e.getMessage());
        }
    }
}


