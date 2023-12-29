package com.student.util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class QueryUtil extends commonUtil{
	
	public static String queryById(String id) throws  SAXException,IOException,ParserConfigurationException{
		NodeList nodeList;
		Element element = null;
		
		nodeList = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder().parse(new File(System.getProperty("catalina.base") + "wtpwebapps\\studentWebApp\\WEB-INF\\queries.xml"))
				.getElementsByTagName(commonConstants.TAG_NAME);
		
		for(int value = 0;value <nodeList.getLength(); value++) {
			element = (Element) nodeList.item(value);
			
			if(element.getAttribute(commonConstants.ATTRIB_NAME).equals(id)) {
				break;
			}
		}
		return element.getTextContent().trim();
		
	}
	
}
