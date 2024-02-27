package engine.exceptions;

import enums.BrowserName;

public class UnsupportedBrowserException extends Exception {
    public UnsupportedBrowserException(String browserName) {
        super(browserName + " - This browser is not supported yet.");
    }
}