package org.kamilkurek.onlinepass.config;

import org.kamilkurek.onlinepass.ApplicationConfig;
import org.springframework.beans.factory.annotation.Required;

/**
 * Created by kamil on 2016-04-14.
 */
public class PropertyValueParserImpl implements PropertyValueParser {

    private ApplicationConfig applicationConfig;

    @Override
    public String parseVariables(String propertyValue) {
        propertyValue = propertyValue.replace("${user.home}", System.getProperty("user.home"));
        propertyValue = propertyValue.replace("${app.name}", applicationConfig.getApplicationName());
        propertyValue = propertyValue.replace("${app.directory}", applicationConfig.getApplicationDirectoryPath());
        return propertyValue;
    }

    @Required
    public void setApplicationConfig(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }
}
