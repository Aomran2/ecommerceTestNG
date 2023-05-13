import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;


public class projectManager {

    WebDriver driver = new ChromeDriver();
    projectElements Hooks = new projectElements(driver);
    SoftAssert soft = new SoftAssert();

    public void loginSteps (String username, String password){
        Hooks.email().sendKeys(username);
        Hooks.password().sendKeys(password);
        Hooks.pressLogin().submit();
    }

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test (priority = 1)
    public void RegisterPage() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        //driver.findElement(By.cssSelector("a[href=\"/register?returnUrl=%2F\"]")).click();
        Hooks.male().click();
        Hooks.fName().sendKeys("test");
        Hooks.lName().sendKeys("automation");
        Hooks.day().sendKeys("15");
        Hooks.month().sendKeys("10");
        Hooks.year().sendKeys("2000");
        Hooks.email().sendKeys("test.automation@automation.com");
        Hooks.cname().sendKeys("Automation Company");
        Hooks.password().sendKeys("123456789");
        Hooks.confirmPassword().sendKeys("123456789");
        Hooks.registerButton().submit();
        String expectedResult = "Your registration completed";
        String actualResult = driver.findElement(Hooks.registerAssertion()).getText();
        soft.assertEquals(actualResult.contains(expectedResult),true ,"success message assertion");
        soft.assertAll();
        //soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/registerresult/1?returnUrl=/","URL assertion");
        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void loginPage() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
        loginSteps("test.automation@automation.com","123456789");
        soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/", "homePage assertion");
        soft.assertAll();
        Thread.sleep(5000);
    }

    @Test (priority = 3)
    public void navigateToCurrency() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/");
        Hooks.currencySign().sendKeys("Euro");
        String expectedResult= "Euro";
        String actualResult = driver.findElement(Hooks.euroAssertion()).getText();
        soft.assertTrue(actualResult.contains(expectedResult),"Euro assertion");
        soft.assertAll();
        Thread.sleep(5000);
    }

    @Test (priority = 4)
    public void searchOfProduct() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/");
        Hooks.searchByName().sendKeys("laptop");
        Hooks.clickSearch().click();
        soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/search?q=laptop","laptop name search assertion");
        soft.assertAll();
        Thread.sleep(5000);
    }

    @Test (priority = 5)
    public void searchOfSKU() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/");
        Hooks.searchByName().sendKeys("LE_TX1_CL");
        Hooks.clickSearch().click();
        soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/search?q=LE_TX1_CL","laptop SKU search assertion");
        soft.assertAll();
        Thread.sleep(5000);
    }

    @Test (priority = 6)
    public void hoverCategory() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/");
        Hooks.moveToCategory().click();
        Hooks.shoesCategory().click();
        soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/shoes", "shoes assertion");
        soft.assertAll();
        Thread.sleep(5000);
    }

    @Test (priority = 7)
    public void slider() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/");
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Hooks.sliderAssertion()));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,175)", "");
        Hooks.homeSlider().click();
        Thread.sleep(5000);
    }

    @Test (priority = 8)
    public void wishlistFeature () throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/htc-one-m8-android-l-50-lollipop");
        Hooks.selectToAdd().click();
        String expectedResult = "The product has been added to your wishlist";
        String actualResult = driver.findElement(Hooks.wishlistAssertionText()).getText();
        soft.assertTrue(actualResult.contains(expectedResult), "success message assertion");
        String backgroundColor = driver.findElement(Hooks.wishlistAssertionRgba()).getCssValue("background-color");
        System.out.println(backgroundColor);
        Thread.sleep(5000);
        soft.assertAll();
    }

    @Test (priority = 9)
    public void facebook () throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/");
        Hooks.facebook().click();
        Thread.sleep(5000);
    }

    @Test (priority = 10)
    public void twitter () throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/");
        Hooks.twitter().click();
        Thread.sleep(5000);
    }

    @Test (priority = 11)
    public void RSS () throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/");
        Hooks.RSS().click();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,175)", "");
        Thread.sleep(5000);
    }

    @Test (priority = 12)
    public void youtube () throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/");
        Hooks.youtube().click();
        Thread.sleep(5000);
    }


    @AfterTest
    public void closeBrowser() throws InterruptedException {
        driver.quit();
        Thread.sleep(3000);    }
}
