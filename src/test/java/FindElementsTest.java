import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Assert.assertEquals(num,8);
        }

    @Test
    public void filterByService(){
        driver.get("https://kwidos.tk/offer/search");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div:nth-child(2)>p-multiselect"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li:nth-child(4) > label"))).click();
        List<WebElement> serviceType= wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[class*='xs-8 s']")));
        for (WebElement element:serviceType){
            Assert.assertEquals(element.getText(),"Architects");
        }
    }
}
