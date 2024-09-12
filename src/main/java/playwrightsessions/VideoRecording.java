package playwrightsessions;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VideoRecording {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext context  = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myvideos/")).setRecordVideoSize(640, 480));
		Page page = context.newPage();
		
		context.close();
		page.close();
		playwright.close();
	}
}
