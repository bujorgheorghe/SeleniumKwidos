import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    @Test
    public void SignUpSuccess () {
        long rand=System.currentTimeMillis();
        driver.get("https://kwidos.tk/auth/register/contractor");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[formcontrolname='firstName']"))).sendKeys("George");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[formcontrolname='lastName']"))).sendKeys("Suz");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[formcontrolname='businessName']"))).sendKeys("LLC");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[formcontrolname='phone']"))).sendKeys("1111111111");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[formcontrolname='email']"))).sendKeys(rand+"@gmail.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[formcontrolname='password']"))).sendKeys("Somepswrd*2");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='col-lg-12 col-xs-12 col-md-12 checkbox-block'] p-checkbox"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[type='submit']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[href='/auth/forgot']")));
        String actualText = driver.findElement(By.cssSelector("[class='card-title']")).getText();
        Assert.assertEquals(actualText, "Please enter your email address and password");
    }

    @Test
    public void SignUpWrongCredentials (){

        driver.get("https://kwidos.tk/auth/register/contractor");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[formcontrolname='firstName']")));
        driver.findElement(By.cssSelector("[formcontrolname='firstName']")).sendKeys("George");
        driver.findElement(By.cssSelector("[formcontrolname='lastName']")).sendKeys("Suz");
        driver.findElement(By.cssSelector("[formcontrolname='businessName']")).sendKeys("LLC");
        driver.findElement(By.cssSelector("[formcontrolname='phone']")).sendKeys("1111111111");
        driver.findElement(By.cssSelector("[formcontrolname='email']")).sendKeys("");
        driver.findElement(By.cssSelector("[formcontrolname='password']")).sendKeys("Somepswrd*2");
        driver.findElement(By.cssSelector("[class='col-lg-12 col-xs-12 col-md-12 checkbox-block'] p-checkbox")).click();

        Assert.assertFalse(driver.findElement(By.cssSelector("[type='submit']")).isEnabled());
    }

    @Test
    public void SignUpEmptyCredentials (){

        driver.get("https://kwidos.tk/auth/register/contractor");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[formcontrolname='firstName']")));
        driver.findElement(By.cssSelector("[class='col-lg-12 col-xs-12 col-md-12 checkbox-block'] p-checkbox")).click();

        Assert.assertFalse(driver.findElement(By.cssSelector("[type='submit']")).isEnabled());
    }
}
