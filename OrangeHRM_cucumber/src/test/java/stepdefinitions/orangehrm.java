package stepdefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class orangehrm 
{
	
	public static WebDriver driver;
	String empid;
	String uname;

	@Given("^i open browser with url \"([^\"]*)\"$")
	public void i_open_browser_with_url(String url) 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}

	@Then("^i should see login page$")
	public void i_should_see_login_page() 
	{
		if(driver.findElement(By.id("btnLogin")).isDisplayed())
		{
			System.out.println("System displayed login page");
		}
		
	}

	@When("^i enter username as \"([^\"]*)\"$")
	public void i_enter_username_as(String uid) 
	{
		driver.findElement(By.id("txtUsername")).sendKeys(uid);
	}

	@When("^i enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String pwd) 
	{
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
	}

	@When("^i click login$")
	public void i_click_login()
	{
		driver.findElement(By.id("btnLogin")).click();
	}

	@Then("^i should see admin module$")
	public void i_should_see_admin_module() 
	{
		if(driver.findElement(By.linkText("Admin")).isDisplayed())
		{
			System.out.println("System displayed admin module");
		}
	}

	@When("^i click logout$")
	public void i_click_logout() 
	{
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
		
	}
	
	@When("^i close browser$")
	public void i_close_browser()
	{
	  driver.close();
	}
	
	@Then("^i should see error message$")
	public void i_should_see_error_message() 
	{
		if(driver.findElement(By.id("spanMessage")).getText().contains("Invalid"))
		{
			System.out.println("System displaying error message");
		}	
	}

	@When("^i goto add employee page$")
	public void i_goto_add_employee_page()
	{
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
	}

	@When("^i enter firstname as \"([^\"]*)\"$")
	public void i_enter_firstname_as(String fname) 
	{
		driver.findElement(By.id("firstName")).sendKeys(fname);
	}

	@When("^i enter lastname as \"([^\"]*)\"$")
	public void i_enter_lastname_as(String lname) 
	{
		driver.findElement(By.id("lastName")).sendKeys(lname);
	}

	@When("^i click save$")
	public void i_click_save()
	{
		empid = driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
	}

	@When("^i goto employee list$")
	public void i_goto_employee_list()
	{
		driver.findElement(By.linkText("Employee List")).click();
	}

	@When("^i search new employee created$")
	public void i_search_new_employee_created()
	{
		driver.findElement(By.id("empsearch_id")).sendKeys(empid);
		driver.findElement(By.id("searchBtn")).click();
	}

	@Then("^i see registered employee in employee list$")
	public void i_see_registered_Employee_details()
	{
		WebElement emptable;
		emptable = driver.findElement(By.id("resultTable"));
		List<WebElement> rows,cols;
		rows = emptable.findElements(By.tagName("tr"));
		for (int i = 1; i < rows.size();i++) 
		{
			cols = rows.get(i).findElements(By.tagName("td"));
			if(cols.get(1).getText().equals(empid))
			{
				System.out.println("New Empolyee is Displayed in Empolyee list");
			}
			break;
		}
			
	}
	
	@When("^i goto add user page$")
	public void i_goto_add_user_page()
	{
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("User Management")).click();
		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.id("btnAdd")).click();	
	}

	@When("^i select user role as \"([^\"]*)\"$")
	public void i_select_user_role_as(String role)
	{
		Select rolelist = new Select(driver.findElement(By.id("systemUser_userType")));
		rolelist.selectByVisibleText(role);	
	}

	@When("^i enter employee name as \"([^\"]*)\"$")
	public void i_enter_employee_name_as(String empname) 
	{
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(empname);
	}
	
	@When("^i enter uname as \"([^\"]*)\"$")
	public void i_enter_uname_as(String uname)
	{
		driver.findElement(By.id("systemUser_userName")).sendKeys(uname);
		this.uname=uname;
	}

	@When("^i enter pword as \"([^\"]*)\"$")
	public void i_enter_pword(String pword) throws InterruptedException 
	{
		driver.findElement(By.id("systemUser_password")).sendKeys(pword);
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(pword);
		Thread.sleep(2000);
		driver.findElement(By.id("btnSave")).click();
	}

	@When("^i search new user created$")
	public void i_search_new_user_created()
	{
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(uname);
		driver.findElement(By.id("searchBtn")).click();
	}

	@Then("^i see registered user in user list$")
	public void i_see_registered_user_in_user_list()
	{
		WebElement userlist;
		userlist = driver.findElement(By.id("resultTable"));
		
		List<WebElement> rows,cols;
		rows = userlist.findElements(By.tagName("tr"));
		
		for(int i=1;i<rows.size();i++)
		{
			cols=rows.get(i).findElements(By.tagName("td"));
			if (cols.get(1).getText().equals(uname)) 
			{
				System.out.println("New User is Displayed in Userlist");
				break;
			}
		}
		
	}









}
