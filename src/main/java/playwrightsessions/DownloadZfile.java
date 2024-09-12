package playwrightsessions;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DownloadZfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=114.0.5735.90/");
		
		Download download = page.waitForDownload(() -> {
			page.click("a:text('chromedriver_mac64.zip')");
		});
		
		System.out.println(download.url());
		System.out.println(download.page().title());
		
		String path = download.path().toString();
		System.out.println(path);
		
		download.saveAs(Paths.get("Ramkumar.zip"));
		System.out.println(download.suggestedFilename());
	}

}
