package LoginTests.NegativeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ErrorMessageTests {
    public static void main(String[] args) {

       WebDriver driver = new ChromeDriver();
       driver.get("https://www.saucedemo.com/");

       String[] userNameList = {"standard_user", "username incorrect", "username incorrect", "", ""};
       String[] passwords = {"password incorrect", "secret_sauce", "password incorrect", "secret_sauce", ""};

       for (int i = 0; i < userNameList.length; i++) {
            String username = userNameList[i];
            String password = passwords[i];

            String[] errorMessages = {
                    "Epic sad face: Username and password do not match any user in this service",
                    "Epic sad face: Username is required",
                    "Epic sad face: Password is required",
            };

            WebElement usernameField = driver.findElement(By.id("user-name"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("login-button"));

            usernameField.sendKeys(username);
            passwordField.sendKeys(password);
            loginButton.click();
            System.out.println("Attempted login with username" + username + " and password- " + password);

            WebElement errorMessageElement = driver.findElement(By.cssSelector("div.error-message-container.error h3"));
            String currentErrorMessage = errorMessageElement.getText();

           if (currentErrorMessage.equals(errorMessages[0]) || currentErrorMessage.equals(errorMessages[1])) {
                System.out.println("Error message displayed: " + currentErrorMessage);
            } else {
                System.out.println("Error message - " + currentErrorMessage);
            }

            usernameField.clear();
            passwordField.clear();
        }

            driver.quit();
    }

}

