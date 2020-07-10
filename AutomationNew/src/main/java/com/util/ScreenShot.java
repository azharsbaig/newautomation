package com.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

	public static String captureScreenShot(WebDriver driver, String ScreenShotName) {
		File dir;
		TakesScreenshot ts = (TakesScreenshot) driver;// typingcasting
		File source = ts.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd___HH_mm_ss");
		DateFormat currentDay = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String dateTime = dateFormat.format(date.getTime());
		dir = new File("./ScreenShots");
		if (!dir.exists()) {
			dir.mkdir();
		}
		dir = new File("./ScreenShots/"+currentDay.format(date));
		if(!dir.exists()) {
			dir.mkdir();
		}
		String destination = currentDir + "//ScreenShots//" +currentDay.format(date)+"//"+ dateTime + "___" + ScreenShotName + ".png";
		try {
			com.google.common.io.Files.copy(source, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// System.out.println("Screen shot taken");

		return destination;

	}

	/*public static void emptyScreenShotFolder() {

		Path pathToBeDeleted = Paths.get("./Screen Shot");
		try {
			Files.walk(pathToBeDeleted).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
		} catch (IOException e1) {

		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}*/

		// Arrays.stream(new File("./Screen Shot").listFiles()).forEach(File::delete);
	}

