import java.io.FileNotFoundException;
import java.util.Properties;

public class propertiesutilities {

	public static void main(String[] args) {
/
**
*this class contains reusable methods to read data from properties file
*@ author TRACK QJSPIDERS
*/
public class propertiesutility
{
	private Properties property;
	/**
	 * this method initializes properties file
	 * @param file path
	 */
	public void propertiesInit(String filepath)
	{
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream(file path);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		property= new properties();
		try
		{
			property.load(fis);
			
		}
		catch(Io Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This method fetches data from properties file based on the key passed
	 * @param key
	 * @return
	 */
	public String readFromProperties(String key) {
		return property.getProperty(key);
	}
}
	}

}
