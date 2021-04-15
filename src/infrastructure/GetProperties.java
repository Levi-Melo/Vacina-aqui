package infrastructure;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class GetProperties {

    public static Properties readFile() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(
                "./resources/config.properties");
        props.load(file);
        return props;
    }

    public static String getPropertie(String varName) throws IOException {
        String returnData;
        Properties prop = readFile();
        returnData = prop.getProperty(varName);
        return returnData;

    }
}