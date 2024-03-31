package LoginTests.NegativeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateLockedUserError {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement Password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        userName.sendKeys("locked_out_user");
        Password.sendKeys("secret_sauce");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3 > button"));
        String errorMessageText = errorMessage.getText();

        if (errorMessageText.equals("Epic sadface: Sorry, this user has been locked out.")) {
            System.out.println(" Sorry, this user has been locked out ");
        } else {
            System.out.println("Error Message is display - Epic sad face: Sorry, this user has been locked out.");

            driver.quit();
        }

    }

}




