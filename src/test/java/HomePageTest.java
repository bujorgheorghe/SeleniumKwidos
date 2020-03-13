import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class HomePageTest extends BaseTest{

    @Test
    public void SignUpSuccess () throws InterruptedException {

        driver.get("https://kwidos.com/auth/register/contractor");
        List<Character> charSet = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', '1', '2'));
        Collections.shuffle(charSet, new Random());
        String rand="";
        for (int i = 0; i < charSet.size(); i++) {
            rand=rand+charSet.get(i);
        }
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("[formcontrolname='firstName']")).sendKeys("George");
        driver.findElement(By.cssSelector("[formcontrolname='lastName']")).sendKeys("Suz");
        driver.findElement(By.cssSelector("[formcontrolname='businessName']")).sendKeys("LLC");
        driver.findElement(By.cssSelector("[formcontrolname='phone']")).sendKeys("1111111111");
        driver.findElement(By.cssSelector("[formcontrolname='email']")).sendKeys(rand+"@gmail.com");
        driver.findElement(By.cssSelector("[formcontrolname='password']")).sendKeys("Somepswrd*2");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[class='col-lg-12 col-xs-12 col-md-12 checkbox-block'] p-checkbox")).click();
        driver.findElement(By.cssSelector("[type='submit']")).click();
        Thread.sleep(2000);
        String actualText = driver.findElement(By.cssSelector("[class='card-title']")).getText();
        Assert.assertEquals(actualText, "Please enter your email address and password");
    }

    @Test
    public void SignUpWrongCredentials () throws InterruptedException{


        driver.get("https://kwidos.com/auth/register/contractor");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[formcontrolname='firstName']")).sendKeys("George");
        driver.findElement(By.cssSelector("[formcontrolname='lastName']")).sendKeys("Suz");
        driver.findElement(By.cssSelector("[formcontrolname='businessName']")).sendKeys("LLC");
        driver.findElement(By.cssSelector("[formcontrolname='phone']")).sendKeys("1111111111");
        driver.findElement(By.cssSelector("[formcontrolname='email']")).sendKeys("");
        driver.findElement(By.cssSelector("[formcontrolname='password']")).sendKeys("Somepswrd*2");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[class='col-lg-12 col-xs-12 col-md-12 checkbox-block'] p-checkbox")).click();
        Thread.sleep(1000);

        Assert.assertFalse(driver.findElement(By.cssSelector("[type='submit']")).isEnabled());
    }

    @Test
    public void SignUpEmptyCredentials () throws InterruptedException{

        driver.get("https://kwidos.com/auth/register/contractor");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[class='col-lg-12 col-xs-12 col-md-12 checkbox-block'] p-checkbox")).click();

        Assert.assertFalse(driver.findElement(By.cssSelector("[type='submit']")).isEnabled());
    }


}
