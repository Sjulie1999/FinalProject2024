package LoginTests.NegativeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Login {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("incorrect_password");
        driver.findElement(By.id("login-button")).click();
        validateErrorMessage(driver, "Epic sadface: Username and password do not match any user in this service");
        driver.navigate().refresh();


        driver.findElement(By.id("user-name")).sendKeys("incorrect_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        validateErrorMessage(driver, "Epic sadface: Username and password do not match any user in this service");
        driver.navigate().refresh();

        driver.findElement(By.id("user-name")).sendKeys("incorrect_user");
        driver.findElement(By.id("password")).sendKeys("incorrect_password");
        driver.findElement(By.id("login-button")).click();
        validateErrorMessage(driver, "Epic sadface: Username and password do not match any user in this service");
        driver.navigate().refresh();


        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        validateErrorMessage(driver, "Epic sadface: Username is required");
        driver.navigate().refresh();

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        validateErrorMessage(driver, "Epic sadface: Password is required");
        driver.navigate().refresh();

        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        validateErrorMessage(driver, "Epic sadface: Username is required");
        driver.navigate().refresh();

        driver.quit();
    }

    public static void validateErrorMessage(WebDriver driver, String expectedErrorMessage) {
        String actualErrorMessage = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3")).getText();
        if (actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("Error Message: " + actualErrorMessage);
        } else {
            System.out.println(expectedErrorMessage);
 }
    }
}
