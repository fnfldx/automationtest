package engine.drivers;

import org.openqa.selenium.WebDriver;

public interface WebDriverInterface {

    void setWebDriverPath();

    WebDriver getDriver();
}