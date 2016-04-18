package org.kamilkurek.onlinepass.config;

/**
 * Created by kamil on 2016-04-14.
 */
public interface ConfigReader {

    String getKeepassFileLocation();
    String getKeepassPassword();
    boolean isConfigOk();

}
