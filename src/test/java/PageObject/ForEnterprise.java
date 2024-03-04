package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForEnterprise extends BasePage {

	public ForEnterprise(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@data-click-key=\"ent_website._business.click.navigation_toggle_Solutions\"]")
	WebElement solution;

	@FindBy(xpath = "//a[@target='https://www.coursera.org/campus']")
	WebElement forCampus;

	public void Solution() {
		solution.click();
		forCampus.click();
	}

}
