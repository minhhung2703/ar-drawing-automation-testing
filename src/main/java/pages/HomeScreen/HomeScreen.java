package pages.HomeScreen;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.baseScreen.BaseScreen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomeScreen extends BaseScreen {
    // Header locator
    private By titleHeaderHomeScreen = AppiumBy.id("ar.drawing.paint.draw.sketch.art.trace.drawing.app:id/tv_title");
    private By musicIconLocator = AppiumBy.id("ar.drawing.paint.draw.sketch.art.trace.drawing.app:id/iv_music");
    private By helpIconLocator = AppiumBy.id("ar.drawing.paint.draw.sketch.art.trace.drawing.app:id/iv_help");
    private By buttonProLocator = AppiumBy.id("ar.drawing.paint.draw.sketch.art.trace.drawing.app:id/iv_pro_go");

    // Tab Category Locator on Home Screen
    private By galleryTabLocator = AppiumBy.xpath("//android.widget.ImageView/following-sibling::android.widget.TextView[@text='From Gallery']");
    private By CameraTabLocator = AppiumBy.xpath("//android.widget.ImageView/following-sibling::android.widget.TextView[@text='From Gallery']");

    // Tab bar Locator
    private By drawingIconLocator = AppiumBy.androidUIAutomator("new UiSelector().text(\"Drawing\")");

    public HomeScreen(AndroidDriver driver){
        super(driver);
    }

    public void clickTabByText(String tabText){
        // dynamicXpath
        String dynamicXpath = String.format("//android.widget.ImageView/following-sibling::android.widget.TextView[@text='%s']", tabText);

        // Waiting Element
        waitForElementVisible(AppiumBy.xpath(dynamicXpath)).click();
        System.out.println(">> Clicked on the tab: " + tabText);
    }

    public boolean isHeaderDisplayed(){
        return waitForElementVisible(titleHeaderHomeScreen).isDisplayed();
    }

    public boolean isMusicIconDisplayed(){
        return waitForElementVisible(musicIconLocator).isDisplayed();
    }

    public boolean isHelpIconDisplayed(){
        return waitForElementVisible(helpIconLocator).isDisplayed();
    }

    public boolean isProButtonDisplayed(){
        return waitForElementVisible(buttonProLocator).isDisplayed();
    }


    // Doing verifyAllCategoryTitleVisible function
    public void verifyAllCategoryTitleVisible(String tabName){
        // Waiting and getting elements
        List<WebElement> elements = waitForAllElementsVisible(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"ar.drawing.paint.draw.sketch.art.trace.drawing.app:id/tv_main_title\" and @text=\"Hot trend\"]/ancestor::androidx.recyclerview.widget.RecyclerView//android.widget.TextView[@resource-id='ar.drawing.paint.draw.sketch.art.trace.drawing.app:id/tv_main_title']"));

        // Make a new list to contains elements
        List<String> allTitles = new ArrayList<>();
        for (WebElement element : elements){
            String titleText = element.getText().trim();
            if(!titleText.isEmpty()){
                allTitles.add(titleText);
            }
        }
        System.out.println("Found title category items: "+ allTitles);

        // Using HashSet to check duplicate element
        Set<String> uniqueTilteCategoryItem = new HashSet<>(allTitles);

        if(uniqueTilteCategoryItem.size() < allTitles.size()){
            // found duplicate title Category Item
            String duplicateName = findDuplicate(allTitles);
            // Sử dụng Assert để làm fail test case
            Assert.fail("Thất bại: Phát hiện tiêu đề bị trùng lặp! Tên trùng: " + duplicateName);
        } else {
            System.out.println("Thành công: Tất cả " + allTitles.size() + " tiêu đề đều duy nhất.");
        }
    }

    private String findDuplicate(List<String> list){
        Set<String> set = new HashSet<>();
        for(String name : list) {
            if(!set.add(name)){
                return name;
            }
        }
        return "undefined";
    }

}
