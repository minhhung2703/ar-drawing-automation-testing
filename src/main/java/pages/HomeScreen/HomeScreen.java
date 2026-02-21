package pages.HomeScreen;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import pages.baseScreen.BaseScreen;

public class HomeScreen extends BaseScreen {
    // Header locator
    private By titleHeaderHomeScreen = AppiumBy.id("ar.drawing.paint.draw.sketch.art.trace.drawing.app:id/tv_title");
    private By musicIconLocator = AppiumBy.id("ar.drawing.paint.draw.sketch.art.trace.drawing.app:id/iv_music");
    private By helpIconLocator = AppiumBy.id("ar.drawing.paint.draw.sketch.art.trace.drawing.app:id/iv_help");
    private By buttonProLocator = AppiumBy.id("ar.drawing.paint.draw.sketch.art.trace.drawing.app:id/iv_pro_go");

    // Tab Locator on Home Screen
    private By galleryTabLocator = AppiumBy.xpath("//android.widget.ImageView/following-sibling::android.widget.TextView[@text='From Gallery']");
    private By CameraTabLocator = AppiumBy.xpath("//android.widget.ImageView/following-sibling::android.widget.TextView[@text='From Gallery']");


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
}
