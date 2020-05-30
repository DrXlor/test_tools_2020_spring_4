import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;
import java.nio.file.Paths;

public class Environment {
    private WebDriver webDriver = null;
    private final String property, path;

    public Environment(String property, String path){
        this.property = property;
        this.path = path;
    }

    public Environment(){
        this.property = "webdriver.chrome.driver";
        this.path = Paths.get(".").toAbsolutePath().normalize().toString() + "\\lab4.2\\src\\main\\resources\\chrome-driver.exe";
    }

    private WebDriver initDriver() {
        List<String> flags = Arrays.asList("--headless=true", "--silent=true", "--log-level=3");
        ChromeOptions opts = new ChromeOptions();

        opts.addArguments(flags);

        System.setProperty("webdriver.chrome.silentLogging", "true");
        System.setProperty(this.property, this.path);

        return new ChromeDriver(opts);
    }

    public WebDriver getWebDriver() {
        if(webDriver == null){
            webDriver = this.initDriver();
        }
        return webDriver;
    }

    public void destroy() {
        if(webDriver != null) webDriver.quit();
    }
}