package genericlibraries;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class contains reusable methods to perform driver related operations
 * I@author SUNILA
 */

public class Webdriverutility {
	private WebDriver driver1;
	private WebDriverWait wait;
	private Actions action;
	private Select select;
	

	/**
	 * This method launches the browser and maximizes it
	 * @param browser
	 * @return
	 */
	public WebDriver launchAndMaximizeBrowser(String browser) {
		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver1=new ChromeDriver();
			break;
		case"firefox":
			WebDriverManager.firefoxdriver().setup();
			driver1=new FirefoxDriver();
			break;
			default:
			System.out.println("Invalid browser info");
		}
		driver1.manage().window().maximize();
		return driver1;
		
	}
	/**
	 * This method is used to navigate to the application
	 * @param Uri
	 */
	public void navigateToApp() {
		String url;
		driver1.get(Uri);
	}
	/**
	 * This method is used to wait until element/elements are found
	 * @param time
	 */
	@SuppressWarnings("deprecation")
	public void waitTillElementFound(long time) {
		driver1.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	/**
	 * This method waits until the element is visible on the web page
	 * @param time
	 * @param element
	 * @return
	 */
	public WebElement explicitWait(Duration time,WebElement element) {
		 wait = new WebDriverWait(driver1,time);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method waits until element is enabled to click
	 * @param element
	 * @param time
	 * @return 
	 * @return
	 */
	
	public WebElement explicitWait(WebElement element,Duration time) {
		wait = new WebDriverWait(driver1,time);
	  return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method waits until title of the web page is displayed
	 * @param title
	 * @param time
	 * @return
	 */
	public Boolean explicitWait(String title,Duration time) {
		WebDriverWait wait = new WebDriverWait(driver1,time);
		return wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * This method is used to mouse hover on an element
	 * @param element
	 */
	public void mouseHoverToElement(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * This method is used to double click on an element
	 * @param element
	 */
	public void doubleClickElement (WebElement element) {
		action =new Actions(driver);
		action.doubleClick(element).perform();
	}
	/**
	 * This method is used to right click on an element
	 * @param element
	 *@param target
	 */
		public void rightClick(WebElement element) {
			action = new Actions(driver);
		action.moveToElement(element).perform();
		}
		/**
		 * This method is used to drag and drop an element to target location
		 * @param element
		 * @param target
		 */
		public void dragAndDropElement(WebElement element,WebElement target) {
			action = new Actions(driver);
			action.dragAndDrop(element, target).perform();
			/**
			 * This method is used to select an element from drop down based on index
			 * @param element
			 * @param index
			 */
			public void selectFromDropdown(WebElement element,int index) {
				select = new Select(element);
					select.selectByIndex(index);
			}
			/**
			 * This method is used to select an element from drop down based on value
			 * @param element
			 * @param value
			 */
			public void selectFromDropdown(WebElement element1,String value) {
				select = new Select(element1);
				select.selectByValue(value);
			}
			/**
			 * This method is used to select an element from drop down based on text
			 * @param text
			 * @param element
			 */
			public void selectFromDropdown(String text,WebElement element1) {
				select =new Select (element1);
				select.selectByVisibleText(text);
				
				
			}
			/**
			 * This method fetches screenshot of the webpage
			 * @param driver
			 * @param jutil
			 * @param className
			 */
			public void takeScreenshot(WebElement driver) {
				TakesScreenshot ts = (TakesScreenshot)driver;
				File src =ts.getScreenshotAs(OutputType.FILE);
				String className;
				Object jutil;
				File dest=new File("./Screenshots/"+className+"_"+ jutil.getCurrentTime()+".png");
						try {
							FileUtils.copyFile(src, dest);
						}catch (IOExpection e){
							e.printStackTrace();}
						}
		
		
		
	 
	  
		
		
		  
	 
		
	}
	

}
