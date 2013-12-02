package com.taobao.bendi.baike.spider.visitor;

import com.taobao.bendi.baike.rule.VisitorRule;

import net.vidageek.crawler.Url;

public interface ICheckVisitor {
	
	/**
	 * 根据访问规则，判断是否抓取该URL
	 * @param url
	 * @return
	 */
	public boolean match(VisitorRule rule, Url url);
}
