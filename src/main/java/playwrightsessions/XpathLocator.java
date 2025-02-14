package playwrightsessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class XpathLocator {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("http://www.amazon.com");
		page.locator("xpath=//input[@id='twotabsearchtextbox']").fill("Macbook pro");
		
		//the below also will work
		page.locator("//input[@id='twotabsearchtextbox']").fill("Macbook pro");
		Locator totalAmazonLinks = page.locator("//a[contains(text(),'Amazon')]");
		System.out.println(totalAmazonLinks.count());
		
		List<String> textList = totalAmazonLinks.allInnerTexts();
		for(String e : textList) {
			System.out.println(e);
		}
		
		page.locator("//a[text()='Joe.Root']/Parent::td/preceding-sibling::td/input[@type='checkbox']").click();
		
		Locator checkboxes = page.locator("//table[@id='resultsTable']//input[@type='checkbox']");
		for(int i=0; i<checkboxes.count();i++) {
			checkboxes.nth(i).click();
		}
		
		page.locator("(//table[@id='resultTable']//input[@type='checkbox'])[1]").click();
		page.locator("(//table[@id='resultTable']//input[@type='checkbox'])[last()s]").click();
	}
	

}
