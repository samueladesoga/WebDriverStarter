import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebElement usernameInput;
    WebElement passwordInput;
    WebElement signInButton;
    public LoginPage(WebDriver driver){
        usernameInput = driver.findElement(By.id("user_login"));
        passwordInput = driver.findElement(By.id("user_password"));
        signInButton = driver.findElement(By.name("commit"));
    }

    public void typeUsername(String username){
        usernameInput.sendKeys(username);
    }

    public void typePassword(String password){
        passwordInput.sendKeys(password);
    }

    public void signIn(){
        signInButton.click();
    }

}
