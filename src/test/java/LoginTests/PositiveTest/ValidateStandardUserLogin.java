package LoginTests.PositiveTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ValidateStandardUserLogin {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        String[] userList = {"problem_user", "performance_glitch_user", "error_user", "visual_user", "standard_user"};
        String password = "secret_sauce";

        for (int i = 0; i < userList.length; i++) {

            driver.get("https://www.saucedemo.com/");

            WebElement userName = driver.findElement(By.id("user-name"));
            WebElement Password = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("login-button"));

            userName.sendKeys(userList[i]);
            Password.sendKeys(password);
            loginButton.click();
            System.out.println("you are logged in successfully to the user "+ userList[i]);

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals("https://www.saucedemo.com/inventory.html")) {
                System.out.println("The Url is correct " + currentUrl);
            } else {
                System.out.println("The Url is incorrect");
            }
            WebElement topTitle = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
            String title11 = topTitle.getText();
            if (title11.equals("Products")) {
                System.out.println("you got the right title :" + title11);
            } else {
                System.out.println("Title has Not been found");
            }
        }
    }
}
