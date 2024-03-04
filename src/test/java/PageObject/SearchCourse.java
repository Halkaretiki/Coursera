package PageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchCourse extends BasePage {

	public SearchCourse(WebDriver driver) {
		super(driver);
	}

	List<String> list = new ArrayList<String>();

	@FindBy(xpath = "//div//input[@class='react-autosuggest__input']")
	WebElement SearchBox;

	@FindBy(xpath = "//button[@aria-label='Show more Language options']//span[@class='cds-button-label']")
	WebElement ShowMore;

	@FindBy(xpath = "//div[@id='checkbox-group']//label//div[@class='cds-checkboxAndRadio-labelText']")
	List<WebElement> Languages;

	@FindBy(xpath = "//div[@class='css-1hllf5q']//button[1]")
	WebElement Apply;

	@FindBy(xpath = "//div[@data-testid='search-filter-group-Level']//div[@class='css-nsxeb5']//div[@class='cds-checkboxAndRadio-labelText']")
	List<WebElement> Levels;

	@FindBy(xpath = "//*[@class='cds-119 cds-113 cds-115 cds-CommonCard-titleLink css-si869u cds-142']")
	List<WebElement> CourseTitle;

	@FindBy(xpath = "//*[@class='cds-119 css-11uuo4b cds-121']")
	List<WebElement> CourseRating;

	@FindBy(xpath = "//div[@class='cds-CommonCard-metadata']")
	List<WebElement> CourseHours;

	@FindBy(xpath = "//span[text()=' Businesses']")
	WebElement Businesses;

	@FindBy(xpath = "//button[@aria-label=\"Submit Search\" and @class=\"nostyle search-button\"]")
	WebElement Search;

	public static List<String> LanguageList;
	public static List<String> LevelList;
	public static List<String> CourseName;
	public static List<String> CourseDuration;
	public static List<String> Course_Rating;

	public void setsearch(String course) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", SearchBox);
		js.executeScript("arguments[0].click();", Search);
		SearchBox.sendKeys(course);
	}

	public void clicks() {
		ShowMore.click();
	}

	public List<WebElement> selectLanguage() {
		return Languages;
	}

	public void apply() {
		Apply.click();
	}

	public List<WebElement> levelList() throws InterruptedException {
		return Levels;
	}

	public List<WebElement> title() {
		return CourseTitle;
	}

	public List<WebElement> rating() {
		return CourseRating;
	}

	public List<WebElement> hours() {
		return CourseHours;
	}

	public void businesses() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Businesses);
	}

}
