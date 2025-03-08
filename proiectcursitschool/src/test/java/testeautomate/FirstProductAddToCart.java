

package testeautomate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import reutilizabile.BasicWebDriver;

public class FirstProductAddToCart extends BasicWebDriver {

    @Test(priority = 11, dependsOnMethods = "testeautomate.TestNavigateToCategory.testNavigateToCategory")
    public void testAddFirstProductToCart() throws InterruptedException {
        
        WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__next']/div[2]/div[1]/main/div[2]/div[2]/div[2]/ul[2]/li[1]/div/a[1]/div/img")));
        actions.moveToElement(firstProduct).perform();
        Thread.sleep(1000);
        firstProduct.click();

        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("#__next > div.content-wrapper.relative.grow.flex.flex-col.justify-between > div.container > main > div.relative > div.flex.items-start.flex-col.space-y-2.md\\:space-y-0.md\\:flex-row.md\\:space-x-8.justify-center.lg\\:-mx-3.my-3.mb-14 > div.w-full.md\\:w-\\[434px\\].lg\\:min-w-\\[530px\\] > div > div.mt-2.mb-\\[30px\\] > div.flex.flex-col.items-center.space-y-2.\\!mt-5.md\\:mt-0.lg\\:flex-row.lg\\:space-y-0.lg\\:space-x-4 > div > div > button > span > span")));
    addToCartButton.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.css-3pxmmn.Modal-container > div.max-height.w-full.sm\\:w-10\\/12.sm\\:mx-3.sm\\:mx-0.xl\\:w-7\\/12.lg\\:w-9\\/12.null.Modal-productAddedToCart-SMTA164BK_1 > div > div > div.relative > div > div.flex.flex-col.lg\\:flex-row.lg\\:justify-between.my-4 > div.hidden.lg\\:flex.lg\\:flex-col.lg\\:w-\\[20\\%\\].justify-center.min-w-fit > a > span > span")));
    WebElement viewCartButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.cssSelector("body > div.css-3pxmmn.Modal-container > div.max-height.w-full.sm\\:w-10\\/12.sm\\:mx-3.sm\\:mx-0.xl\\:w-7\\/12.lg\\:w-9\\/12.null.Modal-productAddedToCart-SMTA164BK_1 > div > div > div.relative > div > div.flex.flex-col.lg\\:flex-row.lg\\:justify-between.my-4 > div.hidden.lg\\:flex.lg\\:flex-col.lg\\:w-\\[20\\%\\].justify-center.min-w-fit > a > span > span")));
    viewCartButton.click();
    Thread.sleep(1000);

   
    }
}















