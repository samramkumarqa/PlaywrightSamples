package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JsPopUpHandle {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.onDialog(dialog -> {
			String text = dialog.message();
			System.out.println(text);
			dialog.accept();
			//dialog.dismiss();
		});
		
		//JS Alerts, Prompt, Confirmation pop ups
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		
		page.click("//button[text()='Click for JS Alert']");
		String result = page.textContent("#result");
		System.out.println(result);
		
		page.click("//button[text()='Click for JS Confirm']");
		String result1 = page.textContent("#result");
		System.out.println(result1);
		
		page.click("//button[text()='Click for JS Prompt']");
		String result2 = page.textContent("#result");
		System.out.println(result2);
		
		page.close();
		browser.close();
		playwright.close();
	}

}
