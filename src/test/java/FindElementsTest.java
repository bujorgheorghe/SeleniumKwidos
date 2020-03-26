import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class FindElementsTest extends BaseTest{
    @Test
    public void numberOfCardsAssert(){
        driver.get("https://kwidos.tk/offer/search");
        int num = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[class='card-header']"))).size();
        Assert.assertEquals(num,10);
        }

    @Test
    public void filterByService(){
        driver.get("https://kwidos.tk/offer/search");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div:nth-child(2) > p-multiselect"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.ui-multiselect-items-wrapper > ul > li:nth-child(1)"))).click();
        List<WebElement> serviceType= wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[class*='xs-8 s']")));
        for (WebElement element:serviceType){
            Assert.assertEquals(element.getText(),"3D Capture");
        }
    }
}
