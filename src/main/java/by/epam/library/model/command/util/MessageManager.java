package by.epam.library.model.command.util;

import java.util.ResourceBundle;

public class MessageManager {
    private final static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("message");

    private MessageManager() {
    }

    public static String getProperty(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}
