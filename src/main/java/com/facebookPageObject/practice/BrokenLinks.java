package com.facebookPageObject.practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
				System.getProperty("user.dir") + "\\DriverLog\\mozila.log");
		FirefoxOptions opt = new FirefoxOptions();
		opt.addPreference("dom.webnotifications.enabled", false);
		driver = new FirefoxDriver(opt);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://facebook.com");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("miraalmamun@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("SarfinaNy@2018", Keys.ENTER);
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		List<WebElement> links = driver.findElements(By.tagName("a"));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		System.out.println("Total links--" + links.size());
		links.addAll(driver.findElements(By.tagName("img")));
		System.out.println("Total links with images--" + links.size());

		List<WebElement> activeLink = new ArrayList<WebElement>();

		HttpURLConnection connection = null;
		for (int i = 0; i < links.size(); i++) {
			if (links.get(i).getAttribute("href") != null) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				activeLink.add(links.get(i));
				System.out.println(i + " " + links.get(i).getAttribute("href") + "-->LINK");

				try {
					connection = (HttpURLConnection) new URL(activeLink.get(i).getAttribute("href")).openConnection();
					connection.connect();
					String response = connection.getResponseMessage();
					connection.disconnect();
					System.out.println(activeLink.get(i).getAttribute("href") + "--->href_link--->" + response);

				} catch (Throwable e) {

					e.printStackTrace();
					System.out.println(e.getMessage());
				}

			}
			if (links.get(i).getAttribute("src") != null) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {

					e.printStackTrace();

				}
				activeLink.add(links.get(i));
				System.out.println(i + " " + links.get(i).getAttribute("src") + "-->IMG");

				try {
					connection = (HttpURLConnection) new URL(activeLink.get(i).getAttribute("src")).openConnection();
					connection.connect();
					String response = connection.getResponseMessage();
					connection.disconnect();
					System.out.println(activeLink.get(i).getAttribute("src") + "--->src_image--->" + response);

				} catch (Throwable e) {

					e.printStackTrace();
					System.out.println(e.getMessage());
				}

			}

		}

		System.out.println("Active links size--" + activeLink.size());

		driver.quit();

	}

}
