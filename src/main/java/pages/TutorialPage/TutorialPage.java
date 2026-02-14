package pages.TutorialPage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import pages.baseScreen.BaseScreen;

public class TutorialPage extends BaseScreen {

    private By headerTitleTutorialLocator = AppiumBy.id("tv_tutorial");

    private By gifTutorialLocator = AppiumBy.xpath(
            "//android.widget.FrameLayout[@resource-id=\"ar.drawing.paint.draw.sketch.art.trace.drawing.app:id/exo_subtitles\"]/android.view.View");

    private By buttonStartLocator = AppiumBy.xpath(
            "//android.widget.FrameLayout[@resource-id=\"ar.drawing.paint.draw.sketch.art.trace.drawing.app:id/exo_subtitles\"]/android.view.View");

    public TutorialPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isHeaderDisplayed() {
        return driver.findElement(headerTitleTutorialLocator).isDisplayed();
    }

    public boolean isGifTutorialDisplayed() {
        return driver.findElement(gifTutorialLocator).isDisplayed();
    }

    public boolean isButtonDisplayed() {
        return driver.findElement(buttonStartLocator).isDisplayed();
    }

    public String getTitleHeaderTutorial() {
        return driver.findElement(headerTitleTutorialLocator).getText();
    }

    public void clickStartButton() {
        driver.findElement(buttonStartLocator).click();
    }

    public void doubleClick() {
        doubleTap(driver.findElement(buttonStartLocator));
    }

}