package pages.baseScreen;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

public class BaseScreen {
    protected AndroidDriver driver;

    public BaseScreen(AndroidDriver driver){
        this.driver = driver;
    }

    public void doubleTap(WebElement element){
        // Get element position & size
        Rectangle rect = element.getRect();
        int centerX = rect.getX()+ rect.getWidth() / 2;
        int centerY = rect.getY()+ rect.getHeight() / 2;

        // Create finger for Android touch
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        // Create W3C action sequence
        Sequence doubleTap = new Sequence(finger,1);

        // Move to element center
        doubleTap.addAction(finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                centerX,
                centerY
        ));

        // Firstly Tap
        doubleTap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        doubleTap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Short pause for Android to detect double-tap
        doubleTap.addAction(new Pause(finger, Duration.ofMillis(100)));

        // Secondly Tap
        doubleTap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        doubleTap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Execute gesture on Android device
        driver.perform(List.of(doubleTap));
    }

}
