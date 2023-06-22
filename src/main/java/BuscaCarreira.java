import java.nio.file.attribute.FileTime;
import java.sql.Time;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuscaCarreira {

	@Test
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com.br/");

		Assert.assertEquals("Google", driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("ntt data");// informa campo de busca ntt data
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(Keys.ENTER);// realiza a busca
		driver.findElement(By.xpath("//*[substring(text(), string-length(text()) - string-length('NTT DATA: Global IT Services Provider & Consultant') + 1) = 'NTT DATA: Global IT Services Provider & Consultant']"))
				.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"navbarLevel0Collapse\"]/div[2]/ul/li[2]/a")).click();// Clicar em
																									// carreira
		driver.findElement(By.xpath("//*[@id=\"collapseRight1\"]/ul/li[2]/a")).click();// Clica no Job Oportunities
		
		String originalWindow = driver.getWindowHandle();// mudança de janela para Job
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	
		WebElement iframeElement = driver.findElement(By.xpath("//*[@id=\"ifrmCookieBanner\"]")); //Procurando o banner do cookie
        driver.switchTo().frame(iframeElement);
		driver.findElement(By.xpath("//*[@id=\"grouped-pageload-Banner\"]/div/div/div/div[3]/button[2]")).click();
		driver.switchTo().defaultContent();//Aceitar o termo
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"sGlobal\"]")).sendKeys("PESSOA ENGENHEIRA DE DADOS"); //Pesquisar na lista de vagas
		driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div/div/div/div[3]/div/div/div[1]/div[1]/div/div/button"))
				.sendKeys(Keys.ENTER);
		
		
		

	}

}
