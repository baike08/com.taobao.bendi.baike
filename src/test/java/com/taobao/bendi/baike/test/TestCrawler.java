package com.taobao.bendi.baike.test;

import java.util.ArrayList;
import java.util.List;

import net.vidageek.crawler.PageCrawler;
import net.vidageek.crawler.PageVisitor;
import net.vidageek.crawler.config.CrawlerConfiguration;

import org.junit.Test;

import com.taobao.bendi.baike.contant.RuleConstant;
import com.taobao.bendi.baike.rule.VRule;
import com.taobao.bendi.baike.rule.VisitorRule;
import com.taobao.bendi.baike.spider.visitor.ElemeVisitor;
import com.taobao.bendi.baike.spider.visitor.TestVisitor;

public class TestCrawler {
	
	@Test
	public void test1() {
		CrawlerConfiguration cfg = new CrawlerConfiguration("http://ele.me/sitemap");
		//cfg.maxPoolSize(3);
		//cfg.minPoolSize(3);
		PageCrawler crawler = new PageCrawler(cfg);
		ElemeVisitor pageVisitor = new ElemeVisitor();
		VisitorRule rules = new VisitorRule();
		VRule r1 = new VRule();
		r1.setType(RuleConstant.Match);
		r1.setRule("http://(.*)/mobile$");
		VRule r2 = new VRule();
		r2.setType(RuleConstant.Match);
		r2.setRule("http://(.*)/login$");
		List<VRule> disAllow = new ArrayList<VRule>();
		disAllow.add(r1);
		disAllow.add(r2);
		rules.setDisAllow(disAllow);
		VRule r3 = new VRule();
		r3.setType(RuleConstant.Match);
		r3.setRule("http://(.*)/sitemap(.*)");
		List<VRule> allow = new ArrayList<VRule>();
		allow.add(r3);
		rules.setDepth(1);
		rules.setAllow(allow);
		pageVisitor.setVisitorRule(rules);
		crawler.crawl(pageVisitor);
		System.out.println("test");
	}

}
