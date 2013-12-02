package com.taobao.bendi.baike.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class XmlParser {
	
	public static Document loadXmlFromStr(String data) {
		Document doc = null;
		SAXReader reader = new SAXReader();
		try {
			doc = reader.read(data);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return doc;
	}
	
	public static Document loadRuleXml() {
		Document doc = null;
		try {
			InputStream input = XmlParser.class
					.getResourceAsStream("/rules.xml");
			SAXReader reader = new SAXReader();

			doc = reader.read(input);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return doc;
	}
	
	public static Document loadXmlFromFile(String path) {
		//注意这里使用的是FileInptStream，而不是FileReader
		Document doc = null;
		try {
			InputStream input = new FileInputStream(path);
			SAXReader reader = new SAXReader();
		
			doc = reader.read(input);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
	}

}
