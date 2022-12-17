import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.List;

public class HomePage {
    private WebDriver driver;
    private static final String url = " https://www.wildberries.by/";
    @FindBy(xpath = "//span[@class='navbar-pc__icon navbar-pc__icon--basket']")
    WebElement basketButton;
    @FindBy(xpath = "//input[@class='search-catalog__input j-wba-header-item']")
    WebElement searchLine;
    @FindBy(xpath = "//div[@id='c84759556']")
    List<WebElement> product;
    @FindBy(xpath = "//a[@class='btn-main-sm j-add-to-basket']")
    WebElement buttonAddToBasket;
    @FindBy(xpath = "//button[@class='search-catalog__btn search-catalog__btn--search']")
    WebElement buttonSubmitSearch;
    @FindBy(xpath = "//li[@class='sizes-list__item']")
    List<WebElement> changeSize;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        PageFactory.initElements(new DefaultElementLocatorFactory(driver), this);
    }
    public HomePage clickBasketButton() {
        basketButton.click();
        return this;
    }

    public HomePage clickSearchLine()
    {
        searchLine.click();
        return this;
    }
    public HomePage writeTextInSearchLine() throws InterruptedException {
        Thread.sleep(5000);
        searchLine.sendKeys("красное платье");
        return this;
    }

    public  HomePage clickSubmitSearch()
    {
        buttonSubmitSearch.click();
        return this;
    }

    public HomePage changeProduct() throws InterruptedException {
        Thread.sleep(5000);
        Actions action = new Actions(driver);
        action.moveToElement(product.get(0));
        action.perform();
        return this;
    }
    public HomePage addProductToBasket()
    {
        buttonAddToBasket.click();
        return this;
    }
    public  HomePage changeSizeProduct() throws InterruptedException {
        Thread.sleep(5000);
        changeSize.get(2).click();
        return this;
    }
    public HomePage openPage() {
        this.driver.get(" https://www.wildberries.by/");
        return this;
    }
}
