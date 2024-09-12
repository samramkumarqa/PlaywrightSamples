package playwrightsessions;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class FileUploadHandle {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		//single one file
		page.setInputFiles("input#filesToUpload", Paths.get("applogin.json"));
		Thread.sleep(4000);
		page.setInputFiles("input#filesToUpload", new Path[0]);
		
		//multiple files
		page.setInputFiles("input#filesToUpload", 
				new Path[] {
						Paths.get("applogin.json"),
						Paths.get("autostate.json"),
						Paths.get("example.png")});
		Thread.sleep(4000);
		page.setInputFiles("input#filesToUpload", new Path[0]);
		
		//run time file - upload:
		page.setInputFiles("input#filesToUpload", new FilePayload("naveen.text", 
				"text/plain", 
				"This is Ramkumar".getBytes(StandardCharsets.UTF_8)));
		page.click("input[value='Press']");
	}

}
