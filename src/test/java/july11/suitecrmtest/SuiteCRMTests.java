package july11.suitecrmtest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import allclasses.allclasses;
import july11.pages.CreateTaskPage;
import july11.pages.HomePagePOM;
import july11.pages.TaskOverview;
import july11.pages.loginPagePOM;
import july11.utilities.ConfigLoader;

public class SuiteCRMTests extends allclasses {
	loginPagePOM loginP;
	HomePagePOM homep;
	CreateTaskPage taskp;
	TaskOverview overp;

	@BeforeMethod
	public void beforemethod() {
		driver.get(ConfigLoader.getProperty("suitecrm.url"));
		loginP = new loginPagePOM(driver);
		homep = new HomePagePOM(driver);
		taskp = new CreateTaskPage(driver);
		overp = new TaskOverview(driver);
	}

	@Test
	public void test() {

		loginP.login(ConfigLoader.getProperty("suitecrm.username"), ConfigLoader.getProperty("suitecrm.password"));
		homep.createnewItem("Create Task");
		taskp.subject.sendKeys(ConfigLoader.getProperty("suitecrm.taskssubject"));
		new Select(taskp.status).selectByVisibleText(ConfigLoader.getProperty("suitecrm.tasksstatus"));
		taskp.description.sendKeys(ConfigLoader.getProperty("suitecrm.description"+ LocalDateTime.now().toString()));
		taskp.save.click();
		
	}
}
