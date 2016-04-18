package org.kamilkurek.onlinepass;

import org.springframework.beans.factory.annotation.Required;

import java.io.File;

/**
 * Created by kamil on 2016-04-14.
 */
public class ApplicationConfig {

    private String applicationName;
    private String applicationDirectoryPath;

    public void init() {
        applicationDirectoryPath = new StringBuilder(System.getProperty("user.home"))
                .append(File.separator)
                .append(".")
                .append(applicationName)
                .append(File.separator)
                .toString();
    }

    @Required
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public String getApplicationDirectoryPath() {
        return applicationDirectoryPath;
    }

    public String getFilePath(String fileName) {
        return applicationDirectoryPath+fileName;
    }
}
