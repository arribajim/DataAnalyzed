package mx.gw.analitic.extensions;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
public class ReadEntity {
	private static final String HOME_GW="C:\\Guidewire\\AXA\\ClaimCenter\\modules\\";
	private static final String EXTENSIONS_BASE_DIR=HOME_GW+"base\\base\\config\\extensions\\";
	private static final String EXTENSIONS_AXA_DIR=HOME_GW+"configuration\\config\\extensions\\";
	private static final String ENTITY="entity";
	public static void main(String[] args) {
		try {// TODO Auto-generated method stub
			System.out.println("entityName\ttag\tname\tdescription");
			File dirBaseEntity = new File(EXTENSIONS_BASE_DIR+ENTITY);
			File dirAxaEntity = new File(EXTENSIONS_AXA_DIR+ENTITY);
			for(File f:dirBaseEntity.listFiles()) {
				for(File fAxa:dirAxaEntity.listFiles()) {
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
			
			
			
		System.out.println("Done...............");         
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
//			    System.out.println(tmp.getNodeName()+ " " +elt.getAttribute("name").length()
//			    +" "+elt.getAttribute("iface"));
			    list.add(dto);
			 }
		} 
		return list;
	}
	
	public static ArrayList<EntityDTO> getEntityList(String pathFile ) throws ParserConfigurationException, SAXException, IOException {
		//Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		 
		//Build DocumentC:\Guidewire\AXA\ClaimCenter\modules\configuration\config\extensions\entity\Adjudicator.eti
		Document document = builder.parse(new File(pathFile));
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
				dto.setEntityName(pathFile);
			    //Print each employee's detail
			    Element elt = (Element) tmp;
			    dto.setTag(tmp.getNodeName());
			    dto.setName(elt.getAttribute("name"));
//			    System.out.println(tmp.getNodeName()+ " " +elt.getAttribute("name").length()
//			    +" "+elt.getAttribute("iface"));
			    list.add(dto);
			 }
		} 
		return list;
	}
	
	

}
