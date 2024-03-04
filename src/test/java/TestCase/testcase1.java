package TestCase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import PageObject.ForEnterprise;
import PageObject.SearchCourse;
import TestBase.BaseClass;
import Utility.ExcelUtils;

public class testcase1 extends BaseClass {
	static List<String> a;
	static List<String> b;
	public static List<String> LanguageList;
	public static List<String> LevelList;
	public static List<String> CourseName;
	public static List<String> CourseDuration;
	public static List<String> Course_Rating;

	@Test(priority = 1)
	public void SetSearch() throws InterruptedException {
		SearchCourse sc = new SearchCourse(driver);
		sc.setsearch("Web Development");
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void SelectLanguage() throws InterruptedException, IOException {
		SearchCourse sc = new SearchCourse(driver);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript(arguments[0].sc.click(), );
		sc.clicks();

		try {
			System.out.println("--------------- Available Languages ---------------");
			for (WebElement lang : sc.selectLanguage()) {
				System.out.println(lang.getText());
				if (lang.getText().contains("English")) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click()", lang);
				}
			}
			LanguageList = new ArrayList<String>();// excel
			for (int i = 0; i < sc.selectLanguage().size(); i++) {
				String k = sc.selectLanguage().get(i).getText();
				LanguageList.add(k);
			}
		} catch (Exception e) {
		}
		sc.apply();
		Thread.sleep(4000);
	}

	public void print_excel() throws InterruptedException, IOException {
		SearchCourse sc = new SearchCourse(driver);
	}

	@Test(priority = 3)
	public void SelectLevel() throws InterruptedException {
		System.out.println("reached..");
		SearchCourse sc = new SearchCourse(driver);

		System.out.println("-------- Available Levels --------");

		LevelList = new ArrayList<String>();// excel
		for (int i = 0; i < sc.levelList().size(); i++) {
			String k = sc.levelList().get(i).getText();
			LevelList.add(k);
		}
		for (WebElement l1 : sc.levelList()) {
			if (l1.getText().contains("Beginner")) {
				l1.click();
			}
			System.out.println(l1.getText());
		}
	}

	@Test(priority = 4)
	public void PrintCourses() {
		SearchCourse sc = new SearchCourse(driver);
		System.out.println("-------- Title Rating & Hours of first two Courses --------");
		CourseName = new ArrayList<String>();// excel
		Course_Rating = new ArrayList<String>();// excel
		CourseDuration = new ArrayList<String>();// excel
		for (int i = 0; i < 2; i++) {
			String Title = sc.title().get(i).getText();
			String Rating = sc.rating().get(i).getText();
			String Hours = sc.hours().get(i).getText();
			String[] temp = Hours.split(" · ");
			System.out.println("Title: " + Title + " Rating:" + Rating + " " + " Hours:" + temp[2] + "hrs.");
			CourseName.add(Title);
			Course_Rating.add(Rating);
			CourseDuration.add(temp[2]);
		}
	}

	@Test(priority = 5)
	public void Businesses() {
		System.out.print("clicked... ");
		SearchCourse sc = new SearchCourse(driver);
		sc.businesses();
		System.out.print("clicked Businesses");
		logger.info(" ...clicked");
	}

	@Test(priority = 6)
	public void Solution() throws InterruptedException {
		ForEnterprise sc = new ForEnterprise(driver);
		sc.Solution();
		Thread.sleep(5000);
	}

	@Test(priority = 6)
	public void printToExcel() throws InterruptedException, FileNotFoundException {
		ExcelUtils.writeToExcel(LanguageList, LevelList, CourseName, CourseDuration, Course_Rating);
	}

}
