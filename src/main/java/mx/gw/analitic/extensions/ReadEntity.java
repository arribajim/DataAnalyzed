package mx.gw.analitic.extensions;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
public class ReadEntity {
	private static final String HOME_GW="C:\\Guidewire\\AXA\\ClaimCenter\\modules\\";
	private static final String HOME_GW_MOD="C:\\Guidewire\\AXA\\ClaimCenter\\modules\\";//"C:\\Guidewire\\multiasistencia\\sf\\ClaimCenter\\modules\\";
	private static final String EXTENSIONS_BASE_DIR=HOME_GW+"base\\base\\config\\extensions\\";
	private static final String EXTENSIONS_AXA_DIR=HOME_GW_MOD+"configuration\\config\\extensions\\";
	private static final String ENTITY="entity";
	private static final String TYPELIST="typelist";
	
	public static void main(String[] args) {
		try {// TODO Auto-generated method stub
			System.out.println("entityName\ttag\tname\tdescription");
			File dirBaseEntity = new File(EXTENSIONS_BASE_DIR+ENTITY);
			File dirModEntity = new File(EXTENSIONS_AXA_DIR+ENTITY);
			
			ArrayList<String> news = getNewsEntities(dirBaseEntity,dirModEntity); 
				
			//new entities
			for(String s:news) {
				isNew(s,dirModEntity);
			}
			//modifed entities
			for(File f:dirBaseEntity.listFiles()) {
				isModified(f);				
			}
			//typelist
			File dirBaseTypelist = new File(EXTENSIONS_BASE_DIR+TYPELIST);
			File dirModTypelist = new File(EXTENSIONS_AXA_DIR+TYPELIST);
			
			
			System.out.println("\n\\n\\nTypekeyName\ttag\tcode\tname\tdescription");
			ArrayList<String> newsTl = getNewsEntities(dirBaseTypelist,dirModTypelist); 
			for(String s:newsTl) {
				isNewTypeList(s,dirModTypelist);
			}
			for(File f:dirBaseTypelist.listFiles()) {
				for(File fAxa:dirModTypelist.listFiles()) {
					//modified
					if(f.getName().equals(fAxa.getName())) {						
						ArrayList<TypekeyDTO> lst1 = getTypekeyList(f);
						ArrayList<TypekeyDTO> lst2 = getTypekeyList(fAxa);
						if(lst2.removeAll(lst1)) {
							for(TypekeyDTO o:lst2) {
								System.out.println(o);
							}
						}
					}
				}
			}
			
			
		System.out.println("Done...............");         
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void isNewTypeList(String s, File dirModEntity) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		for(File fAxa:dirModEntity.listFiles()) {					 
			if(s.equals(fAxa.getName())) {				
				ArrayList<TypekeyDTO> lst2 = getTypekeyList(fAxa);				
					for(TypekeyDTO o:lst2) {
						o.setNew(true);
					System.out.println(o.toString());
				}
			}			
		}
	}

	private static void isNew(String s, File dirModEntity) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		for(File fAxa:dirModEntity.listFiles()) {					 
			if(s.equals(fAxa.getName())) {				
				ArrayList<EntityDTO> lst2 = getEntityList(fAxa);				
					for(EntityDTO o:lst2) {
						o.setNew(true);
					System.out.println(o.toString());
				}
			}			
		}
	}


	private static ArrayList<String> getNewsEntities(File dirBaseEntity, File dirModEntity) {

		ArrayList<String> orig = new ArrayList<String>();
		ArrayList<String> news = new ArrayList<String>();
		Collections.addAll(orig,dirBaseEntity.list());
		Collections.addAll(news,dirModEntity.list());			
		news.removeAll(orig);
		return news;
	}

	private static void isModified(File f) throws ParserConfigurationException, SAXException, IOException {			
		for(File fAxa:new File(EXTENSIONS_AXA_DIR+ENTITY).listFiles()) {
			//MODIFIED ENTITIES OOTB
			if(f.getName().equals(fAxa.getName())) {				
				ArrayList<EntityDTO> lst1 = getEntityList(f);
				ArrayList<EntityDTO> lst2 = getEntityList(fAxa);				
				if(lst2.removeAll(lst1)) {
					for(EntityDTO o:lst2) {
						System.out.println(o);
					}
				}					
			}			
		}		
	}

	public static ArrayList<TypekeyDTO> getTypekeyList(File pathFile ) throws ParserConfigurationException, SAXException, IOException {
		//Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();		
		Document document = builder.parse(pathFile);
		ArrayList<TypekeyDTO> list = new ArrayList<TypekeyDTO>(); 
		//Normalize the XML Structure; It's just too important !!
		document.getDocumentElement().normalize();
		 
		//Here comes the root node
		Element root = document.getDocumentElement();
		
		NodeList listo = root.getChildNodes();
		
		for(int i=0;i< listo.getLength();i++) {
			Node tmp = listo.item(i);
			if (tmp.getNodeType() == Node.ELEMENT_NODE)
			 {
				TypekeyDTO dto = new TypekeyDTO();
				dto.setEntityName(pathFile.getName());
			    //Print each employee's detail
			    Element elt = (Element) tmp;
			    dto.setTag(tmp.getNodeName());
			    dto.setName(elt.getAttribute("name"));
			    dto.setDescription(elt.getAttribute("desc"));
			    dto.setCode(elt.getAttribute("code"));

			    list.add(dto);
			 }
		} 
		return list;
	}
	
	public static ArrayList<EntityDTO> getEntityList(File pathFile ) throws ParserConfigurationException, SAXException, IOException {
		//Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();		
		Document document = builder.parse(pathFile);
		ArrayList<EntityDTO> list = new ArrayList<EntityDTO>(); 
		//Normalize the XML Structure; It's just too important !!
		document.getDocumentElement().normalize();
		 
		//Here comes the root node
		Element root = document.getDocumentElement();
		
		NodeList listo = root.getChildNodes();
		
		for(int i=0;i< listo.getLength();i++) {
			Node tmp = listo.item(i);
			if (tmp.getNodeType() == Node.ELEMENT_NODE)
			 {
				EntityDTO dto = new EntityDTO();
				dto.setEntityName(pathFile.getName());
			    //Print each employee's detail
			    Element elt = (Element) tmp;
			    dto.setTag(tmp.getNodeName());
			    dto.setName(elt.getAttribute("name"));
			    dto.setDescription(elt.getAttribute("desc")); 
			    list.add(dto);
			 }
		} 
		return list;
	}
	
	
	 
	
	

}
