package org.kamilkurek.onlinepass;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by kamil on 2016-04-14.
 */
public class PropertiesLoaderImpl implements PropertiesLoader {

    @Override
    public boolean loadProperties(Properties properties, String fileLocation) throws IOException  {
        try (InputStream inputStream = new FileInputStream(fileLocation)) {
            properties.load(inputStream);
            if(properties.isEmpty()) {
                return false;
            }
        }
        return true;
    }

}
