package Testing_Pages;
import demoProject.UiElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
// Assuming UiElements is accessible and contains necessary methods

public class Elements_Tab {
    
    WebDriver driver;
    private final String BASE_URL = "https://demoqa.com/";
    private final By ELEMENTS_CARD = By.xpath("//div[@class='card mt-4 top-card'][1]"); 
    private final By MENU_ITEM_LIST = By.xpath("//div[@class='element-list collapse show']");
    
    // ----------------- TEST LIFECYCLE -----------------

    @BeforeTest
    public void setupDriver() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }
    
    @BeforeMethod
    public void navigateToElementsPage() {
        driver.navigate().to(BASE_URL);
        UiElements.slideToElement(driver, ELEMENTS_CARD); 
        UiElements.clickElement(driver, ELEMENTS_CARD);
        UiElements.waitForElementVisisble(driver, MENU_ITEM_LIST);
    }
    
    @DataProvider(name="CheckingElementTab")
    public Object[][] getElementData(){
        // Data: {Menu Item XPath, Expected Header XPath}
        return new Object[][] {
            {"//span[text()='Text Box']", "//h1[text()='Text Box']"},      
            {"//span[text()='Check Box']", "//h1[text()='Check Box']"}, 
            {"//span[text()='Radio Button']", "//h1[text()='Radio Button']"},
            {"//span[text()='Web Tables']", "//h1[text()='Web Tables']"},
            {"//span[text()='Buttons']", "//h1[text()='Buttons']"},
            {"//span[text()='Links']", "//h1[text()='Links']"},
            {"//span[text()='Broken Links - Images']", "//h1[text()='Broken Links - Images']"},
            {"//span[text()='Upload and Download']", "//h1[text()='Upload and Download']"},
            {"//span[text()='Dynamic Properties']", "//h1[text()='Dynamic Properties']"}
        };
    }
//    
//    @Test(dataProvider = "CheckingElementTab")
//    public void validateElementsTab(String menuItemXPath, String expectedHeaderXPath) {
//    	UiElements.slideToElement(driver, By.xpath(menuItemXPath));
//        UiElements.clickElement(driver, By.xpath(menuItemXPath));
//        boolean isHeaderDisplayed = UiElements.waitForElementVisisble(driver, By.xpath(expectedHeaderXPath));
//        Assert.assertTrue(isHeaderDisplayed,"header was NOT displayed after clicking the link.");
//    }
    
    @Test
    public void validateCheckbox(){
    	String home_Nav="//div[@id='tree-node']//button[@aria-label='Toggle']";
    	String download_Nav="//li[contains(@class,'rct-node-expanded') and .//span[text()='Downloads']]//button[@aria-label='Toggle']";
    	UiElements.clickElement(driver, By.xpath("//span[text()='Check Box']"));
    	//svg element Very important
    	UiElements.clickElement(driver, By.xpath(home_Nav));
    	UiElements.slideToElement(driver, By.xpath(download_Nav));
    	UiElements.clickElement(driver, By.xpath(download_Nav));
    	

    	
    }
    
    @AfterTest
    public void teardownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}