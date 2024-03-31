package SanityTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class BuyProductScenario {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement Password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        userName.sendKeys("standard_user");
        Password.sendKeys("secret_sauce");
        loginButton.click();

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("The Url is correct " + currentUrl);
        } else {
            System.out.println("The Url is incorrect");
        }

        WebElement pageTitle;
        pageTitle = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String title = pageTitle.getText();
        if (title.equals("Products")) {
            System.out.println("you got the right title: " + title);
        } else {
            System.out.println("Title has Not been found");
        }

        WebElement addToCartFirstItem = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartFirstItem.click();
        WebElement addToCartSecondItem = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
        addToCartSecondItem.click();

        WebElement cartIcon = driver.findElement(By.cssSelector("#shopping_cart_container > a > span"));
        String cartIconCountText = cartIcon.getText();

        if (cartIconCountText.equals("2")) {
            System.out.println("You have got 2 Items in your cart");
        } else {
            System.out.println("Your cart is empty");
        }
        cartIcon.click();

        String currentUrl2 = driver.getCurrentUrl();
        if (currentUrl2.equals("https://www.saucedemo.com/cart.html")) {
            System.out.println("The Url is correct " + currentUrl2);
        } else {
            System.out.println("The Url is incorrect");
        }


        WebElement pageTitle2 = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String title2 = pageTitle2.getText();
        if (title2.equals("Your Cart")) {
            System.out.println("You got the right title: " + title2);
        } else {
            System.out.println("Title has not been found");
        }

        List<WebElement> cartItems = driver.findElements(By.cssSelector(".cart_item"));
        int numberOfItemsInCart = 2;
        if (cartItems.size() == numberOfItemsInCart) {
            System.out.println("Number of items in cart is correct.");
        }
        else {
            System.out.println("Number of items in cart is incorrect. The expected items is: " + numberOfItemsInCart + ".");
        }

        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();

        String currentUrl3 = driver.getCurrentUrl();
        if (currentUrl3.equals("https://www.saucedemo.com/checkout-step-one.html")) {
            System.out.println("The Url is correct " + currentUrl3);
        } else {
            System.out.println("The Url is incorrect");
        }

        WebElement firstName = driver.findElement(By.id("first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement zipCode = driver.findElement(By.id("postal-code"));

        firstName.sendKeys("Julie");
        lastName.sendKeys("Shabo");
        zipCode.sendKeys("1234567");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        String currentUrl4 = driver.getCurrentUrl();
        if (currentUrl4.equals("https://www.saucedemo.com/checkout-step-two.html")) {
            System.out.println("The Url is correct " + currentUrl4);
        } else {
            System.out.println("The Url is incorrect");
        }

        WebElement pageTitle3 = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String title3 = pageTitle3.getText();
        if (title3.equals("Checkout: Overview")) {
            System.out.println("You got the right title: " + title3);
        } else {
            System.out.println("Title has not been found");
        }

        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();

        String currentUrl5 = driver.getCurrentUrl();
        if (currentUrl5.equals("https://www.saucedemo.com/checkout-complete.html")) {
            System.out.println("The Url is correct " + currentUrl5);
        } else {
            System.out.println("The Url is incorrect");
        }

        WebElement pageTitle4 = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String title4 = pageTitle4.getText();
        if (title4.equals("Checkout: Complete!")) {
            System.out.println("You got the right title: " + title4);
        } else {
            System.out.println("Title has not been found");
        }

        WebElement pageTitle5 = driver.findElement(By.cssSelector("#checkout_complete_container > h2"));
        String title5 = pageTitle5.getText();
        WebElement pageTitle6 = driver.findElement(By.cssSelector("#checkout_complete_container > div"));
        String title6 = pageTitle6.getText();

        if (title5.equals("Thank you for your order!") && title6.equals("Your order has been dispatched, and will arrive just as fast as the pony can get there!")){
            System.out.println("The main title: " + title5 +
                    "and the secondary title: " + title6 + " is correct.");
        }else{
            System.out.println("The main title and the secondary title is incorrect.");
        }

        driver.quit();
    }

}