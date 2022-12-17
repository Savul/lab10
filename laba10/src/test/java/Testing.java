import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class Testing {
    WebDriver webDriver = new ChromeDriver();
    String resultTestFindProductInBasket = "Корзина";
    String resultTestDeleteProductInBasket = "В корзине пока пусто";
    By targetTestFindProductInBasket = By.xpath("//h1[@class='basket-section__header active']");
    By targetTestDeleteProductBasket = By.xpath("//h1[@class='section-header']");

    @Test
    public void BuyProductAndCheckInBasket() throws InterruptedException {
        new HomePage(webDriver).openPage().clickSearchLine().writeTextInSearchLine().clickSubmitSearch().changeProduct().addProductToBasket().changeSizeProduct().clickBasketButton();
        new BasketPage(webDriver);
        AssertJUnit.assertEquals(BasketPage.checkProgress(this.targetTestFindProductInBasket), this.resultTestFindProductInBasket);
    }
    @Test
    public void DeleteProductFromBasket() throws InterruptedException {

        BuyProductAndCheckInBasket();
        new HomePage(webDriver).openPage().clickBasketButton();
        int numberOfProduct = new BasketPage(webDriver).CheckWhatIsProduct();
        new BasketPage(webDriver).deleteElement(numberOfProduct);
        AssertJUnit.assertEquals(BasketPage.checkProgress(this.targetTestDeleteProductBasket), this.resultTestDeleteProductInBasket);
    }
}
