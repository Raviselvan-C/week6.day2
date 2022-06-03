package week6.day3;



import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CreateLead extends BaseClass{
	
	@BeforeTest
	public void setFileName() {
		fileName= "ceateLead";
	}
	
	@Test(dataProvider="testData")
	public void runCreateLead(String Uname,String pwd,String cmp,String FName,String LName ) {
		driver.findElement(By.id("username")).sendKeys(Uname);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cmp);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(FName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(LName);
		driver.findElement(By.name("submitButton")).click();
	}
	


}
