import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.core.cli.Main;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;


public class SearchQA {
	
	private WebDriver driver;
	
	@Given("I access the VV Test page")
	public void i_access_the_vv_test_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\RAFAEL\\MyWorkSpace\\eclipse-workspace\\AutomacaoVvTest\\drivers\\chromedriver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://www.lourencodemonaco.com.br/vvtest/");
	}

	@Given("access the Research - QA menu")
	public void access_the_research_qa_menu() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"menu-item-226\"]/a")).click();
	  
	}

	@When("I fill in all required fields")
	public void i_fill_in_all_required_fields() {
		
		driver.findElement(By.name("fname")).sendKeys("Rafael");
		driver.findElement(By.name("lname")).sendKeys("Cardoso Pereira");
		driver.findElement(By.name("lname")).sendKeys(Keys.TAB);
		driver.findElement(By.name("email")).sendKeys("rafael@teste.com.br");
		driver.findElement(By.id("nf-field-8")).sendKeys("rafael@teste.com.br");
		driver.findElement(By.id("nf-label-class-field-10-1")).click();
		driver.findElement(By.name("lname")).sendKeys(Keys.TAB);
		driver.findElement(By.name("nf-field-11")).click();
		Select drpTempoQA = new Select(driver.findElement(By.name("nf-field-11")));
		drpTempoQA.selectByVisibleText("mais de 5 anos");
		Select drpAtracao = new Select(driver.findElement(By.name("nf-field-12")));
		drpAtracao.selectByVisibleText("Desafio");
		driver.findElement(By.name("lname")).sendKeys(Keys.TAB);
		driver.findElement(By.id("nf-label-class-field-13-1")).click();
		driver.findElement(By.id("nf-field-14")).sendKeys("Java e C#");
		
	}

	@Then("should be directed to a successful page")
	public void should_be_directed_to_a_successful_page() throws Exception {
		
		driver.findElement(By.id("nf-field-16")).click();
		Thread.sleep(2000);
	    
		WebElement element = driver.findElement(By.className("nf-response-msg"));
		String strng = element.getText();
		System.out.println("O texto exibido é: "+strng);
		Assert.assertEquals("Your form has been successfully submitted.", strng);
		//driver.quit();
		driver.close();
		
		
	}

}
