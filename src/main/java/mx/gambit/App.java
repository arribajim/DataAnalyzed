package mx.gambit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.ZoneId;
import java.util.Calendar;

import org.json.simple.parser.JSONParser;

import mx.gambit.parcer.ParceCountriesJson;
import mx.gambit.parcer.ParceEventsJson;

/**
 * Hello world!
 *
 */
public class App {
	
	static FileTime getAttributes(String pathStr) throws IOException {
	    Path p = Paths.get(pathStr);
	    BasicFileAttributes view
	       = Files.getFileAttributeView(p, BasicFileAttributeView.class)
	              .readAttributes();
	    view.creationTime().toInstant().atZone(ZoneId.systemDefault());
	    
	    return view.creationTime().toMillis()>view.lastModifiedTime().toMillis()?
	    		view.lastModifiedTime():view.creationTime();
	  }
	
	public static void main(String[] args) {
	    //jsonParce();
		try{
			ParceEventsJson parce = new ParceEventsJson();
			Calendar cal = Calendar.getInstance();
			File f = new File("C:\\tmp\\files\\data");
			cal.setTimeInMillis(f.lastModified());
			System.out.println("Start redod "+cal.getTime());
			
			for(String fullName:f.list()) {
				String xpath="C:\\tmp\\files\\data\\"+fullName;				
				if(xpath.contains("107082495")) {
					System.out.println(xpath);
					parce.parceGambit(xpath, getAttributes(xpath).toMillis());
				}
				
				
			}
			
			
			
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		System.out.println("done");

	}
	
	
	private static void jsonParce() {
		JSONParser jsonParser = new JSONParser();      
        try 
        {
        	FileReader reader = new FileReader("c://tmp/files/GetEvents_ES.json");
        	
            Object obj = jsonParser.parse(reader);
            ParceEventsJson parce = new ParceEventsJson();
            parce.parceEvents(obj);
            parce.getEventList().forEach( event ->{
            	System.out.println(event.sqlInsert());
            });
            parce.parceParticipants(obj);
            parce.getParticipantList().forEach(part ->{
            	System.out.println(part.sqlInsert());
            });
            
            parce.parceGames(obj);
            parce.getGameList().forEach(elt->{
            	System.out.println(elt.sqlInsert());
            });
            parce.parceResults(obj);
            parce.getResultList().forEach(elt->{
            	System.out.println(elt.sqlInsert());
            });
            
            reader = new FileReader("c://tmp/files/GetCountries.json");
            obj = jsonParser.parse(reader);
        	ParceCountriesJson parcec = new ParceCountriesJson();
        	parcec.parceCountries(obj);
        	parcec.parceLeagues(obj);
        	parcec.getCountriesList().forEach(l ->{
        		System.out.println(l.sqlInsert());
        	});
        	parcec.getLeaguesList().forEach(l ->{
        		System.out.println(l.sqlInsert());
        	});

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}
