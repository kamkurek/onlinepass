package org.kamilkurek.onlinepass;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by kamil on 2016-04-14.
 */
public interface PropertiesLoader {

    boolean loadProperties(Properties properties, String fileLocation) throws IOException;

}
