import org.openqa.selenium.*;

public class Utility {

    public static String getElementFromPageBy(WebDriver driver, String type, String query) {
        try {
            WebElement byQuery = null;
            if (type.equals("tag")) {
                byQuery = driver.findElement(By.tagName(query));
            } else if (type.equals("xpath")) {
                byQuery = driver.findElement(By.xpath(query));
            } else {
                return "Type available: tag, xpath";
            }
            return byQuery.getText();
        } catch (NoSuchElementException exception) {
            System.out.println("This page doesn`t contain element with `" + query + "`!");
            return "";
        }
    }

}