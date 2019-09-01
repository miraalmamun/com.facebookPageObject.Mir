
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class ICICI {

	public static void main(String[] args) throws ParseException, InterruptedException {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
		// profile and options
	

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://loan.icicibank.com/asset-portal/auto-loan/check-eligibility?WT.mc_id=NLI_Apply_Online_page");
	
     	// loan type 
		driver.findElement(By.xpath("//*[@id='check-eligibility-page']/div[4]/div/div/form/div[2]/div[1]/div/div/button/span[1]")).click();	 
		driver.findElement(By.xpath("//span[text()='Used Car Loan']")).click();
		
		// phone
		driver.findElement(By.name("mobileNumber")).sendKeys("8877665544");
		
		// city
		//driver.findElement(By.id("1516082393303")).sendKeys("Bangalore"); - id changes - its variable
		driver.findElement(By.xpath("//span[@class='input input--hoshi']/input")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//span[@class='input input--hoshi']/input")).sendKeys(Keys.ENTER);
		
		// house status
		driver.findElement(By.xpath("//*[@id='check-eligibility-page']/div[4]/div/div/form/div[5]/div[2]/div/div/button/span[1]")).click();
		driver.findElement(By.xpath("//span[text()='Owned']")).click();
		
		// Date
		//driver.findElement(By.xpath("//*[@id='city-map-icon']/img")).click(); -  2 same ids
		driver.findElement(By.xpath("//img[@ng-src='assets/images/calendar.svg']")).click();
		String dob="24/04/1955";
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sd.parse(dob);
		String month =  new SimpleDateFormat("MMM").format(date);
		int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
		String day = new SimpleDateFormat("d").format(date);
		System.out.println(day+" - "+ month+" - "+year );
		
	//	String displayedYear=driver.findElement(By.xpath("//*[@id='datepicker-283-3087-title']/strong")).getText(); id changes
		while(true){
			String displayedYear=driver.findElement(By.xpath("//*[starts-with(@id,'datepicker-')]/strong")).getText();
			int lowerYear=Integer.parseInt(displayedYear.split(" - ")[0]);
			int upperYear=Integer.parseInt(displayedYear.split(" - ")[1]);
			System.out.println(lowerYear);
			System.out.println(upperYear);
			if(lowerYear<=year && year<=upperYear){// found
				driver.findElement(By.xpath("//span[text()='"+year+"']")).click();
				Thread.sleep(2000);//later fix with explicit wait
				driver.findElement(By.xpath("//button[@class='btn btn-default']/span[text()='"+month+"']")).click();
				Thread.sleep(2000);//later fix with explicit wait
				driver.findElement(By.xpath("//span[text()='"+day+"']")).click();
				break;
			}else{// not visible
				if(upperYear<year){// click forward
					driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-chevron-right']")).click(); // 2 but first of interest
				}else if(year<lowerYear){// click back
					driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-chevron-left']")).click(); // 2 but first of interest
				}
			}
		}
		

	}

}
