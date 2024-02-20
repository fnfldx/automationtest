package enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum BrowserName {
    CHROME("webdriver.chrome.driver"),
    FIREFOX("webdriver.gecko.driver");
    public final String webDriverPathProperty;

    BrowserName(String webDriverPathProperty) {
        this.webDriverPathProperty = webDriverPathProperty;
    }
}