package org.kamilkurek.onlinepass.config;

import org.kamilkurek.onlinepass.ApplicationConfig;
import org.kamilkurek.onlinepass.PropertiesLoader;
import org.springframework.beans.factory.annotation.Required;

import java.io.*;
import java.util.Properties;

/**
 * Created by kamil on 2016-04-14.
 */
public class ConfigReaderImpl implements ConfigReader {

    private Properties properties;
    private ApplicationConfig applicationConfig;
    private PropertyValueParser propertyValueParser;
    private PropertiesLoader propertiesLoader;
    private boolean configOk;

    public ConfigReaderImpl() {
        properties = new Properties();
    }

    public void init() {
        String fileLocation = applicationConfig.getFilePath("config.properties");
        try {
            configOk = propertiesLoader.loadProperties(properties, fileLocation);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getKeepassFileLocation() {
        return propertyValueParser.parseVariables(properties.getProperty("keepass.file.location"));
    }

    @Override
    public String getKeepassPassword() {
        return properties.getProperty("keepass.password");
    }

    @Override
    public boolean isConfigOk() {
        return configOk;
    }

    @Required
    public void setApplicationConfig(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    @Required
    public void setPropertyValueParser(PropertyValueParser propertyValueParser) {
        this.propertyValueParser = propertyValueParser;
    }

    @Required
    public void setPropertiesLoader(PropertiesLoader propertiesLoader) {
        this.propertiesLoader = propertiesLoader;
    }
}
