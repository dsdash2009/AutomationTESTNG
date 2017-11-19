package com.app.utils;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XML_File {

	@Test
	public void Xml_Read() 
	{
		
		try {
		//String fpath=System.getProperty("user.dir");
		//File ifile= new File(fpath+File.separator+ "Login_XML.xml");
		
		String fpath=System.getProperty("user.dir");
		InputStream ifile= new FileInputStream(fpath + "/TestData/Csv/" + "DB_XML.xml");
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        
        Document doc= dBuilder.parse(ifile);
        doc.getDocumentElement().normalize();
     
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        
        NodeList nList=doc.getElementsByTagName("USER");
        System.out.println("------------------------------");
        
        for(int i=0;i<nList.getLength();i++)
        {
        	Node nNode=nList.item(i);
        	System.out.println("\nCurrent Element :" +nNode.getNodeName());
        	
        	if(nNode.getNodeType()==Node.ELEMENT_NODE){
        		
        		Element eElement=(Element) nNode;
        		
        		//System.out.println("USER_ID: "+ eElement.getAttribute("id"));
        		System.out.println("Login : "+ eElement.getElementsByTagName("login").item(0).getTextContent());
        		System.out.println("First_Name : "+ eElement.getElementsByTagName("first_name").item(0).getTextContent());
        		System.out.println("Last_Name : "+ eElement.getElementsByTagName("last_name").item(0).getTextContent());
        		
        	}
        	
        	}
		}
        	
        catch(Exception e)
        {
        	e.printStackTrace();
        }
            
	
		}
	
}
