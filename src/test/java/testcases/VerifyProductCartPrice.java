package testcases;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VerifyProductCartPrice {

	public static void main(String[] args) {
		


		WebDriver driver = new ChromeDriver(); // 123

		driver.get("https://naveenautomationlabs.com/opencart/");

		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("iphone");

		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

		WebElement obj = driver.findElement(By.xpath("//p[@class='price']"));

		String iphoneCostFull = obj.getText();

		System.out.print(obj.getText());
		System.out.println("============================================");

		String[] spl = iphoneCostFull.split(" ");
		
		System.out.println(Arrays.toString(spl));
		
	
	     String SringIphoneCost= spl[0].replaceAll("[^0-9\\.]","");
		System.out.println(SringIphoneCost); //123.20
		
		
		Double iphoneCost = Double.parseDouble(SringIphoneCost);
		System.out.println(iphoneCost);
		
		
		//add to cart --
		
		
		//use clear method to clear search bock
		// samsung -- search
		
		// samsung 
		
		//samsung cost --
		//Add toc cart ---
		
		//double productTotal == uphoenCost+SamsungCot ;
		
		//Conbmbvert to string --"$"+365.19 =$365.19
		
		
		//go to cart
		

		//capture the totalAmount from the cart --- 
		
		//  $365.19
		  
		 

		}

}
