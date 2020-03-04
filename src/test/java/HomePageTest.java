import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HomePageTest {


    @Test
    public void LoginSuccess () throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testkwidos.tk/auth/login");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#email")).sendKeys("ghebizi@yahoo.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("12345678");
        driver.findElement(By.cssSelector("[type='submit']")).click();
        Thread.sleep(2000);
        String actualText = driver.findElement(By.cssSelector("[class='title']")).getText();
        Assert.assertEquals(actualText, "Let's get it started!");
        driver.quit();

    }

    @Test
    public void LoginWrongCredentialsTest () throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testkwidos.tk/auth/login");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#email")).sendKeys("George@email.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("WrongPassword");
        driver.findElement(By.cssSelector("[type='submit']")).click();
        Thread.sleep(2000);
        String actualText = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
        Assert.assertEquals(actualText, "Username or password is incorrect");
        driver.quit();

    }

    @Test
    public void LoginEmptyCredentialsTest () throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testkwidos.tk/auth/login");


        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#email")).sendKeys("");
        driver.findElement(By.cssSelector("#password")).sendKeys("");
        driver.findElement(By.cssSelector("[type='submit']")).click();
        Thread.sleep(2000);
        String actualText = driver.findElement(By.cssSelector("div:nth-child(4)")).getText();
        Assert.assertEquals(actualText, "Password is required");
        driver.quit();

    }
}
