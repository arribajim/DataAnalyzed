package mx.ca.analitic.liente;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.FileCopyUtils;

/**
 * Hello world!
 *
 */
public class App 
{
	 static String htmlText = "<!DOCTYPE html>" +
	            "    <html>" +
	            "    <head>" +
	            "       <title>Java Magazine</title>" +
	            "    </head>" +
	            "    <body>" +
	            "       <h1>Hello World!</h1>" +
	            "    </body>" +
	            "</html>";
    public static void main( String[] args )
    {
    	
    	URL connection;
		try {
			connection = new URL("https://sports.caliente.mx/es_MX");
		
		
		InputStream is = connection.openStream();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		FileCopyUtils.copy(is, bos);
		String data = new String(bos.toByteArray());
		System.out.println(data);
		
//    	 Document document = Jsoup.parse(data);
//         Elements allElements = 
//             document.getAllElements();
//         for (Element element : allElements) {
//             System.out.println(element.nodeName() 
//             + " " + element.ownText());
//         }	
    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}
