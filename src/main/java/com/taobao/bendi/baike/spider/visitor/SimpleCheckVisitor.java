package com.taobao.bendi.baike.spider.visitor;

import net.vidageek.crawler.Url;

import com.taobao.bendi.baike.rule.VRule;
import com.taobao.bendi.baike.rule.VisitorRule;

public class SimpleCheckVisitor implements ICheckVisitor {

	/*
	 * @see com.taobao.bendi.baike.spider.visitor.ICheckVisitor#match(com.taobao.bendi.baike.rule.VisitorRule, net.vidageek.crawler.Url)
	 */
	public boolean match(VisitorRule rule, Url url) {
		if(rule == null)
			return false;
		if(url == null)
			return false;
		if(url.depth() > rule.getDepth())	//
			return false;

		if(rule.getDisAllow() != null && !rule.getDisAllow().isEmpty()) {
			for(VRule r : rule.getDisAllow()) {
				if(r==null) continue;
				if(r.isMatch(url.link())) {
					System.out.println("[DisAllow] match:" + url.link() + " vs " + r.getRule());
					return false;
				}
			}
		}
		// 
		if(rule.getAllow() != null && !rule.getAllow().isEmpty()) {
			for(VRule r : rule.getAllow()) {
				if(r==null) continue;
				if(r.isMatch(url.link())) {
					System.out.println("[Allow] match:" + url.link() + " vs " + r.getRule());
					return true;
				}
			}
		}
		System.out.println("[INFO] default result = " + rule.isDefaultRule());
		return rule.isDefaultRule();
	}

}
