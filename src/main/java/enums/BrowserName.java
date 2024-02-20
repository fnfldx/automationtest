package enums;

import lombok.Getter;
import lombok.ToString;
import lombok.RequiredArgsConstructor;

@Getter
@ToString
@RequiredArgsConstructor
public enum BrowserName {
    CHROME("webdriver.chrome.driver"),
    FIREFOX("webdriver.gecko.driver");
    public final String webDriverPathProperty;

    BrowserName(String path) {
        this.webDriverPathProperty = path;
    }
}
