package mx.cal.download;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class GambitMX {

	public static void main(String[] args) {
		try {
			URL connection = new URL("https://sports.caliente.mx/es_MX");
			
			InputStream is = connection.openStream();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			
			String data = new String(bos.toByteArray());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
