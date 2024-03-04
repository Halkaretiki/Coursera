package TestCase;

import java.util.Scanner;

import org.testng.annotations.Test;
import PageObject.CoursesForCampus;
import TestBase.BaseClass;

public class testcase2 extends BaseClass {

	@Test(priority = 1)
	public void form() {
		CoursesForCampus cc = new CoursesForCampus(driver);
		cc.firstName("Kartiki");
//		Scanner sc = new Scanner (System.in);
//		String surname = sc.nextLine();
		cc.lastName("Halkare");
		cc.phone("9382274324");
		cc.email("kartikihalkaregmail.com");
		cc.institutionName("Cognizant");
		cc.institutionType("Graduate or Professional School");
		cc.country("India");
		cc.state("Tamil Nadu");
		cc.department("Other");
		cc.description("Learner Support");
		cc.jobRole("Student");
		cc.submit();
		System.out.println("------Error Message------");
		System.out.println(cc.error());
 
		
	}

}
