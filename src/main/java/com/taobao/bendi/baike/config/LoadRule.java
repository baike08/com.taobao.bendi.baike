package com.taobao.bendi.baike.config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import com.taobao.bendi.baike.contant.RuleConstant;
import com.taobao.bendi.baike.rule.VRule;
import com.taobao.bendi.baike.rule.VisitorRule;

public class LoadRule {
	
	public static VisitorRule init() {
		Document doc = XmlParser.loadRuleXml();
		if(doc == null) {
			return null;
		}
		Element root = doc.getRootElement();
		if(root == null) {
			return null;
		}
		VisitorRule rules = new VisitorRule();
		Element ele = null;
		int depth = 1;
		// 获取深度
		for (Iterator i = root.elementIterator("depth"); i.hasNext();) {
			ele = (Element) i.next();
			depth = Integer.parseInt(ele.attributeValue("value"));
		}
		if(depth > 0) {
			rules.setDepth(depth);
		}else {
			rules.setDepth(1);
		}
		
		parseVRule(root, "disallow");
		parseVRule(root, "allow");
		
		return rules;
	}

	private static List<VRule> parseVRule(Element root, String key) {
		if(root == null) {
			return null;
		}
		Element ele = null;
		Element e = null;
		List<VRule> rls = new ArrayList<VRule>();
		for (Iterator i = root.elementIterator(key); i.hasNext();) {
			ele = (Element) i.next();
			for(Iterator it = ele.elementIterator("rule"); it.hasNext();) {
				e = (Element) it.next();
				String type = e.attributeValue("type");
				String reg = e.attributeValue("regular");
				VRule v = new VRule();
				v.setRule(reg);
				v.setType(RuleConstant.getRuleConstant(type));
				System.out.println(v.toString());
				rls.add(v);
			}
		}
		
		
		return rls;
	}
}
