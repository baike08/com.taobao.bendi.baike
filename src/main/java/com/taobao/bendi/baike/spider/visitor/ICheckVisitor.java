package com.taobao.bendi.baike.spider.visitor;

import com.taobao.bendi.baike.rule.VisitorRule;

import net.vidageek.crawler.Url;

public interface ICheckVisitor {
	
	/**
	 * ���ݷ��ʹ����ж��Ƿ�ץȡ��URL
	 * @param url
	 * @return
	 */
	public boolean match(VisitorRule rule, Url url);
}
