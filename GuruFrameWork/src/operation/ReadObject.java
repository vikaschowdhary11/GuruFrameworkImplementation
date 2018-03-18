package operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadObject {

	Properties p=new Properties();
	
	public Properties getObjectRespository() throws IOException {
		FileInputStream inputStream=new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\object\\object.properties"));
		p.load(inputStream);
		return p;		
	}
}
