package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class VotingClient {

	/*
	*
	* --
	*
	 */
	public static void main(String[] args) {
		final URL urlDriver = VotingClient.class.getClassLoader().getResource("drivers/chrome/chromedriver-win64/chromedriver.exe");
		System.out.println();
		if (urlDriver == null) throw new RuntimeException("The ChromeDriver doesn't exist");

		System.setProperty("webdriver.chrome.driver", urlDriver.getPath());
		final WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.google.com/");

		driver.findElement(By.name("q")).sendKeys("YouTube");

		final WebElement searchIcon = driver.findElement(By.name("btnK"));
		searchIcon.click();
	}
}
