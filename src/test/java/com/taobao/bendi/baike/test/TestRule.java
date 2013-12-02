package com.taobao.bendi.baike.test;

import java.util.ArrayList;
import java.util.List;

import net.vidageek.crawler.Url;

import org.junit.Test;

import com.taobao.bendi.baike.config.LoadRule;
import com.taobao.bendi.baike.contant.RuleConstant;
import com.taobao.bendi.baike.rule.VRule;
import com.taobao.bendi.baike.rule.VisitorRule;
import com.taobao.bendi.baike.spider.visitor.ICheckVisitor;
import com.taobao.bendi.baike.spider.visitor.SimpleCheckVisitor;

public class TestRule {
	
	@Test
	public void testRule() {
		LoadRule.init();
		VisitorRule vRule = new VisitorRule();
		VRule r1 [] = new VRule [4];
		r1[0] = new VRule();
		r1[1] = new VRule();
		r1[2] = new VRule();
		r1[3] = new VRule();
		r1[0].setRule("test rule equal");
		r1[0].setType(RuleConstant.Equal);
		r1[1].setRule("test rule unequals");
		r1[1].setType(RuleConstant.Equal);
		r1[2].setRule("[a-z]+");
		r1[2].setType(RuleConstant.Unmatch);
		r1[3].setRule("^com");
		r1[3].setType(RuleConstant.Unmatch);
		vRule.setDepth(2);
		List<VRule> ruleList = new ArrayList<VRule>();
		ruleList.add(r1[0]);
		
		ruleList.add(r1[1]);
		ruleList.add(r1[2]);
		ruleList.add(r1[3]);
		//vRule.setAllow(ruleList);
		vRule.setDisAllow(ruleList);
		
		Url url = new Url("testcom", 1);
		
		ICheckVisitor check = new SimpleCheckVisitor();
		System.out.println("result = " + check.match(vRule, url));
		
	}

}
