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

	public static void main(String[] args) {

		try {
			
			new SaveFromURL("https://trailhead.salesforce.com/en/modules");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("done");

	}

	static void readFromFile() throws Exception {
		File input = new File("/tmp/test.html");
		Document doc = Jsoup.parse(input, "UTF-8", "http://google.com/");
		Elements allElements = doc.getAllElements();
		for (Element element : allElements) {
			if(element.nodeName().equals("button") &&
					element.attr("title").contains("Atlas de Guadalajara") ){
				for (Element elt : element.getAllElements()) {
					System.out.println(elt.nodeName()+"\t"+ elt.attr("class") + "\t" + elt.ownText().replace("\n", " "));
				}
			}
			
		}
	}

	static void readFromURL() throws Exception {
		final String PATH = "https://trailhead.salesforce.com/en/modules";// https://sports.caliente.mx/es_MX
		URL connection;
		connection = new URL(PATH);

		InputStream is = connection.openStream();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		FileCopyUtils.copy(is, bos);
		String data = new String(bos.toByteArray());
		// System.out.println(data);

		Document document = Jsoup.parse(data);
		Elements allElements = document.getAllElements();
		for (Element element : allElements) {
			System.out.println(element.nodeName() + " " + element.ownText());
		}
	}
	
	//TODO table for teams and Leagues
	static String[] getTeamsMXLeague() {
		return new String[] {
				"America","Atlas","Atletico San Luis","Cruz Azul","Guadalajara",
				"Juarez","Leon","Monterrey","Morelia","Necaxa","Pachuca","Puebla",
				"Queretaro","Santos Laguna","Tijuana","Toluca","UANL","UNAM","Veracruz"
		};
	}
}
