package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		//Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);
		Browser browser = playwright.chromium().launch(lp);
		Page page = browser.newPage();
		page.navigate("http://www.amazon.com");
		
		String title = page.title();
		System.out.println("Page title is : "+title);
		
		String url = page.url();
		System.out.println("url is : "+ url);
		page.navigate("http://www.google.com");
		
		browser.close();
		playwright.close();
	}

}
