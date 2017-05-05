import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    WebElement usernameInput;
    WebElement passwordInput;
    WebElement signInButton;
    public LoginPage(ChromeDriver driver){
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
