package pages.SplashScreen;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import pages.baseScreen.BaseScreen;

public class SplashScreen extends BaseScreen {
    private By splashTutorial = AppiumBy.id("ar.drawing.paint.draw.sketch.art.trace.drawing.app:id/lv_icon");

    public SplashScreen(AndroidDriver driver){
        super(driver);
    }

    public boolean isDisplaySplashScreen(){
        return driver.findElement(splashTutorial).isDisplayed();
    }
}
