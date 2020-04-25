package configuration;

import logger.LoggerManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public Properties getPropertiesFromFile(String propertiesFileName) {
        LoggerManager loggerManager = new LoggerManager(PropertiesLoader.class);

        InputStream inputStream = null;

        Properties properties = new Properties();
        try {
            loggerManager.getLoggerInfo("Trying to load properties with file name: " + propertiesFileName);

            inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);
            if (inputStream != null) {
                properties.load(inputStream);
                loggerManager.getLoggerInfo("Successfully loaded properties for file: " + propertiesFileName);
            } else {
                throw new FileNotFoundException("Property file '" + propertiesFileName + "' not found in the classpath");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot load properties due to IOException!");
        } finally {
            closeResource(inputStream);
        }

        return properties;
    }

    private void closeResource(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
