package mx.gambit;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.FileCopyUtils;

/**
 * Hello world!
 *
 */
public class App {
	// https://sports.caliente.mx/es_MX
	public static void main(String[] args) {

		try {
			
			SaveFromURL urlMain = new SaveFromURL(args[0]);
			System.out.println(urlMain.getFileOutput());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("done");

	}	
}
