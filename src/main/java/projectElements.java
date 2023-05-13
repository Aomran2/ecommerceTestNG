import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class projectElements {
WebDriver driver;
public projectElements(WebDriver driver) {
    this.driver=driver;
}

    public WebElement male (){
        return driver.findElement(By.cssSelector("input[id=\"gender-male\"]"));
    }
    public WebElement fName (){
        return driver.findElement(By.xpath("//input[@id=\"FirstName\"]"));
    }

    public WebElement lName (){
        return driver.findElement(By.xpath("//input[@id=\"LastName\"]"));
    }

    public WebElement day (){
    return driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]"));
    }

    public WebElement month (){
        return driver.findElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]"));
    }
    public WebElement year (){
        return driver.findElement(By.xpath("//select[@name=\"DateOfBirthYear\"]"));
    }

    public WebElement email (){
        return driver.findElement(By.xpath("//input[@name=\"Email\"]"));
    }

    public WebElement cname (){
        return driver.findElement(By.xpath("//input[@id=\"Company\"]"));
    }

    public WebElement password (){
    return driver.findElement(By.xpath("//input[@id=\"Password\"]"));
    }

    public WebElement confirmPassword (){
        return driver.findElement(By.xpath("//input[@name=\"ConfirmPassword\"]"));
    }

    public WebElement registerButton (){
        return driver.findElement(By.xpath("//button[@id=\"register-button\"]"));
    }

    public By registerAssertion (){
        return By.xpath("//div[@class=\"page-body\"]");
    }

    public WebElement pressLogin (){
        return driver.findElement(By.xpath("//button[@class=\"button-1 login-button\"]"));
    }

    public WebElement currencySign (){
        return driver.findElement(By.xpath("//select[@name=\"customerCurrency\"]"));
    }

    public By euroAssertion (){
        return By.xpath("//select[@name=\"customerCurrency\"]");
    }

    public WebElement searchByName (){
        return driver.findElement(By.xpath("//input[@id=\"small-searchterms\"]"));
    }

    public WebElement clickSearch (){
        return driver.findElement(By.xpath("//button[@class=\"button-1 search-box-button\"]"));
    }

    public WebElement moveToCategory (){
        return driver.findElement(By.xpath("//img[@alt=\"Picture for category Apparel\"]"));
    }

    public WebElement shoesCategory (){
        return driver.findElement(By.xpath("//img[@title=\"Show products in category Shoes\"]"));
    }

    ////img[@src="https://demo.nopcommerce.com/images/thumbs/0000089_banner_02.webp"]
    public WebElement homeSlider (){
        return driver.findElement(By.xpath("//a[@class=\"nivo-control active\"]"));
    }

    public By sliderAssertion (){
        return By.xpath("//a[@class=\"nivo-control active\"]");
    }

    public WebElement facebook (){
    return driver.findElement(By.xpath("//a[@href=\"http://www.facebook.com/nopCommerce\"]"));
    }

    public WebElement twitter (){
        return driver.findElement(By.xpath("//a[@href=\"https://twitter.com/nopCommerce\"]"));
    }

    public WebElement RSS (){
        return driver.findElement(By.xpath("//a[@href=\"/news/rss/1\"]"));
    }

    public WebElement youtube (){
        return driver.findElement(By.xpath("//a[@href=\"http://www.youtube.com/user/nopCommerce\"]"));
    }

    public WebElement selectToAdd (){
        return driver.findElement(By.cssSelector("button[id=\"add-to-wishlist-button-18\"]"));
    }

    public By wishlistAssertionText (){
        return By.cssSelector("p[class=\"content\"]");
    }

    public By wishlistAssertionRgba (){
        return By.cssSelector("div[class=\"bar-notification success\"]");
    }
}
