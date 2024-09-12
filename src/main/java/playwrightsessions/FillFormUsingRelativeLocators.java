package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FillFormUsingRelativeLocators {
	static Page page;
	
	public static void main(String[] args) {
			Playwright playwright = Playwright.create();
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			
			page = browser.newPage();
			page.navigate("https://www.orangehrm.com/en/30-day-free-trial/");
			
			page.locator("input:below(label:text('Full Name'))").first().fill("Ram");
			page.locator("input:below(label:text('Email'))").first().fill("Ram@gmail.com");
			page.locator("input:below(label:text('Phone Number'))").first().fill("Ram");
			
			page.locator("input:near(:text('Newsletter'))").fill("Ram");
	}

}
