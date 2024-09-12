package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelector {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		//text locators
		Page page = browser.newPage();
		page.navigate("https://www.orangehrm.com/en/30-day-free-trial/");
		//page.locator("text=Contact Sales").click();
		page.locator("text=Privacy Policy").first().click();
		
		Locator links = page.locator("text=Privacy Policy");
		for(int i =0; i<=links.count(); i++) {
			System.out.println(links.nth(i).textContent());
			String text =links.nth(i).textContent();
				if(text.contains("Service Privacy Policy")) {
					links.nth(i).click();
					break;
				}
		}
		
		// You can use for any element, locators used not only for links
		page.navigate("https://demo.opencart.com/index.php?route=account/login");
		String header = page.locator("div.well 	h2:has-text('New Customer')").textContent();
		System.out.println(header);
		
		//below both codes are same
		String pageHeader = page.locator("'Your Store'").textContent();
		//String pageHeader = page.locator("text=Your Store").textContent();
		System.out.println(pageHeader);
		
		//button
		page.locator("form input:has-text('Login')").click();
	}

}
