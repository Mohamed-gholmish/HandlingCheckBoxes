package HandlingCheckBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LocateClickCheckBox {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");

        List<WebElement> radioButtons = driver.findElements(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-1enofrn r-1ozqkpa']"));
        Duration duration = Duration.ofSeconds(10);

        WebDriverWait wait= new WebDriverWait(driver,duration);
        for (int i = 0; i < radioButtons.size(); i++) {
            WebElement radioButton = radioButtons.get(i);
            String radioText = radioButton.getText();
            System.out.println(radioText);

            if (radioText.equalsIgnoreCase("Govt. Employee")) {
                wait.until(ExpectedConditions.elementToBeClickable(radioButton));

                radioButton.click();

                break;
            } else {
                System.out.println("That's not the element");
            }
        }

        driver.quit();
    }
}
