import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.support.ui.Select;



public class FreelancifyTest {
    WebDriver driver = new ChromeDriver();

    @Test
    public void userShouldBeOnDashBoardWhenLoggedInSuccessfully(){
        login("SamClient", "password");
        WebElement loginNoticeElement = driver.findElement(By.className("feedback-green"));
        assertTrue(loginNoticeElement.isDisplayed());
        String loginNotice = loginNoticeElement.getText();
        assertEquals("Successful login message wasnt displayed", "Signed in successfully.", loginNotice);
        String dashboardHeader = driver.findElement(By.className("dashboard-sort")).getText();
        assertEquals("My Open Projects", dashboardHeader);
    }


    @Test
    public void userShouldbeAbleToCreateAProjectSuccessfully(){
        login("SamClient", "password");
        driver.findElement(By.className("style11")).click();
        WebElement projectTypeTitle = driver.findElement(By.className("style3"));
        assertTrue(projectTypeTitle.isDisplayed());
        WebElement basicWebsiteDesignCategory = driver.findElement(By.linkText("Basic Website Design"));
        basicWebsiteDesignCategory.click();
        WebElement projectDetails = driver.findElement(By.className("style3"));
        assertTrue(projectDetails.isDisplayed());
        driver.findElement(By.id("project_title")).sendKeys("Brand New Project");
        driver.findElement(By.id("project_description")).sendKeys("Maiden Selenium Class");
        driver.findElement(By.id("project_skill_list")).sendKeys("IT, Computer Science");
        WebElement selectElement = driver.findElement(By.id("end_date"));
        selectElement.click();
        new Select(selectElement).selectByValue("3");
        WebElement selectElement1 = driver.findElement(By.id("budget"));
        selectElement1.click();
        new Select(selectElement1).selectByVisibleText("$300 - $500");

        driver.findElement(By.className("green-button")).click();

        String successfulNotification = driver.findElement(By.className("feedback-green")).getText();
        assertEquals("Your project is live! Now enter any questions you have for freelancers and they will soon come and join your discussion.", successfulNotification);


        // Close the driver

    }
    private void login(String username, String password) {
        driver.get("https://staging-freelancify.herokuapp.com");
        WebElement loginLInkText = driver.findElement(By.linkText("Login"));
        loginLInkText.click();

        LoginPage freelancifyLoginPage = new LoginPage(driver);
        freelancifyLoginPage.typeUsername(username);
        freelancifyLoginPage.typePassword(password);
        freelancifyLoginPage.signIn();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
