package playwrightsessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorConcept {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		//locators
		
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		//page.navigate("https://academy.naveenautomationlabs.com");
		page.navigate("https://www.orangehrm.com/en/30-day-free-trial/");
		
		//single element
		//Locator contactSales = page.locator("text = CONTACT SALES");
		//int intcontactSales = page.locator("text = CONTACT SALES").count();
		//contactSales.hover();
		//contactSales.first().click();
		//contactSales.last().click();
		
		Locator countryOptions = page.locator("select#Form_getForm_Country option");
		System.out.println(countryOptions.count());
		
		/*for(int i=0; i<=countryOptions.count(); i++) {
			String text = countryOptions.nth(i).textContent();
			System.out.println(text);
		}*/
		
		List<String> optionTextList = countryOptions.allTextContents();
		for(String e : optionTextList) {
			System.out.println(e);
		}
		
		optionTextList.forEach(ele -> System.out.println(ele));
		//System.out.println(intcontactSales);
		
		/*Locator loginBtn = page.locator("text = Login");
		loginBtn.hover();
		loginBtn.click();*/
	}

}
