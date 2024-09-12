package playwrightsessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TotalAmazonLinks {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		
		page.navigate("https://www.amazon.in");
		
		//Playwright supported locators
		List <String> amazonlinkslist = page.locator("a:has-text('Amazon')").allInnerTexts();
		
		amazonlinkslist.stream().forEach(e -> System.out.println(e));
	}
}
