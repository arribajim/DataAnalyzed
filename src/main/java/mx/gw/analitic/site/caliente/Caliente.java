package mx.gw.analitic.site.caliente;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Caliente {

	static void readFromFile(File input) throws Exception {		 
		Document doc = Jsoup.parse(input, "UTF-8", "https://sports.caliente.mx/es_MX");
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
}
