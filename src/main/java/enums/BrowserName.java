package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum BrowserName {
    CHROME("webdriver.chrome.driver"),
    FIREFOX("webdriver.gecko.driver"),
    OPERA("");
    public final String webDriverPathProperty;
}