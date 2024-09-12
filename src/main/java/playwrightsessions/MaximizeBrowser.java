package playwrightsessions;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MaximizeBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				double width = (int)screenSize.getWidth();
				double height = (int)screenSize.getHeight();
				System.out.println(width + ":" + height);
		
				Playwright playwright = Playwright.create();
				Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
				
				BrowserContext context  = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
				Page page = context.newPage();
				page.navigate("http://www.amazon.com");
				
	}

}
