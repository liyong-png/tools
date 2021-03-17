package url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class UrlProperties {

	private static final String ACTIONPATH = "url.properties";
	
	/**
	 * @param propertiesName 属性的名称
	 * @return
	 */
	public static Object getUrlProperties(String propertiesName) {
		InputStream is = UrlProperties.class.getClassLoader().getResourceAsStream(ACTIONPATH);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		Properties props = new Properties();  
        try {  
            props.load(br);  
            return props.get(propertiesName);
        } catch (IOException e) {
            e.printStackTrace();
        }
		return props; 
	}
	
	public static void main(String[] args) {
		Object urlProperties = getUrlProperties("bdUrl");
		System.out.println(urlProperties);
	}

}
