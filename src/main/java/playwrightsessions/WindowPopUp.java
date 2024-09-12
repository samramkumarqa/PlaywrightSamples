package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowPopUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext bx1 = browser.newContext();
		Page page = bx1.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com/");
		
		//1. open a new tab.window/popup after clicking on link on the parent
		Page popup = page.waitForPopup(() -> {
			
			page.click("img[alt='OrangeHRM on twitter']");
		});
			
		popup.waitForLoadState();
		popup.navigate("https://www.google.com");
		
		System.out.println("pop up 	window title: " + popup.title());
		popup.close();
		System.out.println("parent window title" + page.title());
		page.close();
		
		//2. open a new tab.window/popup after clicking on link on the parent
				/*Page popup = page.waitForPopup(() -> {
					
					page.click("a[target='_blank']");
				});
					
				popup.waitForLoadState();
				popup.navigate("https://www.google.com");
				
				System.out.println("pop up 	window title: " + popup.title());
				popup.close();
				System.out.println("parent window title" + page.title());
				page.close();*/
	}

}
