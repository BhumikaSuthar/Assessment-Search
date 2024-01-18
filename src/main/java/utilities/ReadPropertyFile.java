package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	
	
	public String getProperty(String key) throws IOException
	{
		String currentPath = System.getProperty("user.dir");
		FileInputStream inputStream = new FileInputStream(new File(currentPath+"/config.properties"));
		Properties prop  = new Properties();
		prop.load(inputStream);
		return prop.get(key).toString();
	}

}
