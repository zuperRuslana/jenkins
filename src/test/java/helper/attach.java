package helper;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class attach {
    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] screenshotAs(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
    @Attachment(value = "page source",type="text/plain")
    public static byte[] pageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value="{attachName}", type="text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }
    public static void browserConsoleLogs(){
        attachAsText(
            "Browser console log",
        String.join("\n", Selenide.getWebDriverLogs(BROWSER))
        );
        }
    }

