import com.rummolprod999.chromedriver.ChromeDriverBuilder
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.chrome.ChromeOptions
import java.io.File

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val driver_home = "your driver home"

        // 1  if use chromeOptions, recommend use this
        // ChromeDriverBuilder could throw RuntimeError, you can catch it, *catch it is unnecessary
        val chrome_options = ChromeOptions()
        chrome_options.addArguments("--window-size=1920,1080")

        //chrome_options.addArguments("--headless=new"); when chromedriver > 108.x.x.x
        //chrome_options.addArguments("--headless=chrome"); when chromedriver <= 108.x.x.x
        val service = ChromeDriverService.Builder()
            .usingDriverExecutable(File(driver_home))
            .usingAnyFreePort()
            .build()

        //ChromeDriver chromeDriver1 = new ChromeDriver(service);
        val chromeDriver1 = ChromeDriverBuilder()
            .build(chrome_options, driver_home)

        // 2  don't use chromeOptions
        //ChromeDriver chromeDriver2 = new ChromeDriverBuilder()
        //        .build("your driver home");
        chromeDriver1["your url"]

        //chromeDriver2.get("your url");
    }
}
