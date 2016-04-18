package org.kamilkurek.onlinepass;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by kamil on 2016-04-14.
 */
public class CustomUserDetailsService implements UserDetailsService {

    private Properties properties;
    private ApplicationConfig applicationConfig;
    private PropertiesLoader propertiesLoader;
    private boolean configOk;

    public CustomUserDetailsService() {
        properties = new Properties();
    }

    public void init() {
        String fileLocation = applicationConfig.getFilePath("users.properties");
        try {
            propertiesLoader.loadProperties(properties, fileLocation);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        String password = properties.getProperty(userName);
        if(password!=null) {
            UserDetails userDetails = new UserDetailsAdapter(userName, password);
            return userDetails;
        }
        return null;
    }

    @Required
    public void setApplicationConfig(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    @Required
    public void setPropertiesLoader(PropertiesLoader propertiesLoader) {
        this.propertiesLoader = propertiesLoader;
    }
}
