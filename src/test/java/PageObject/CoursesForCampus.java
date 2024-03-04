package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CoursesForCampus extends BasePage {
	public CoursesForCampus(WebDriver driver) {
		super(driver);
	}
	JavascriptExecutor js =(JavascriptExecutor)driver;
	
	@FindBy(id = "FirstName")
	WebElement FirstName;
	
	@FindBy(id = "LastName")
	WebElement LastName;
	
	@FindBy(id = "Phone")
	WebElement Phone;
	
	@FindBy(id = "Email")
	WebElement Email;
	
	@FindBy(id = "Company")
	WebElement InstitutionName;
	
	@FindBy(xpath = "//select[@id='Institution_Type__c']")
	WebElement InstitutionType;
	
	@FindBy(xpath = "//select[@id='Title']")
	WebElement JobRole;
	
	@FindBy(xpath = "//select[@id='Department']")
	WebElement Department;
	
	@FindBy(xpath = "//select[@id='What_the_lead_asked_for_on_the_website__c']")
	WebElement Description;
	
	@FindBy(xpath = "//select[@id='Country']")
	WebElement Country;
	
	@FindBy(xpath = "//select[@id='State']")
	WebElement State;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement Submit;
	
	@FindBy(xpath = "//div[@role='alert' and @class='mktoErrorMsg']")
	WebElement Error;

	public void firstName(String fname) {
		FirstName.sendKeys(fname);
	}

	public void lastName(String lname) {
		LastName.sendKeys(lname);
	}

	public void phone(String phone) {
		Phone.sendKeys(phone);
	}

	public void email(String email) {
		Email.sendKeys(email);
	}

	public void institutionName(String institution) {
		InstitutionName.sendKeys(institution);
	}

	public void institutionType(String type) {
		js.executeScript("arguments[0].click();", InstitutionType);
		Select IT = new Select(InstitutionType);
		IT.selectByVisibleText(type);
	}

	public void jobRole(String role) {
		js.executeScript("arguments[0].click();", JobRole);
		Select JR = new Select(JobRole);
		JR.selectByVisibleText(role);
	}

	public void department(String department) {
		js.executeScript("arguments[0].click();", Department);
		Select DN = new Select(Department);
		DN.selectByVisibleText(department);
	}

	public void description(String description) {
		js.executeScript("arguments[0].click();", Description);
		Select DD = new Select(Description);
		DD.selectByVisibleText(description);
	}

	public void country(String country) {
		js.executeScript("arguments[0].click();", Country);
		Select C = new Select(Country);
		C.selectByVisibleText(country);
	}

	public void state(String state) {
		js.executeScript("arguments[0].click();", State);
		Select S = new Select(State);
		S.selectByVisibleText(state);
	}

	public void submit() {
		js.executeScript("arguments[0].click();", Submit);
	}

	public String error() {
		String err = Error.getText();
		return err;
	}
}
