package com.taobao.bendi.baike.spider.visitor;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import com.taobao.bendi.baike.rule.VisitorRule;

import net.vidageek.crawler.Page;
import net.vidageek.crawler.PageVisitor;
import net.vidageek.crawler.Status;
import net.vidageek.crawler.Url;

public class ElemeVisitor implements PageVisitor {

	private static int index = 0;
	private VisitorRule visitorRule;
	private ICheckVisitor checkVisitor;
	
	public VisitorRule getVisitorRule() {
		return visitorRule;
	}

	public void setVisitorRule(VisitorRule visitorRule) {
		this.visitorRule = visitorRule;
	}

	public ICheckVisitor getCheckVisitor() {
		return checkVisitor;
	}

	public void setCheckVisitor(ICheckVisitor checkVisitor) {
		this.checkVisitor = checkVisitor;
	}

	private boolean write2File(String result, String fileName) {
		FileOutputStream out = null; 
		BufferedOutputStream buff1=null;  
		try {
			File file = new File(fileName);
			out = new FileOutputStream(file);
			buff1=new BufferedOutputStream(out);   
			buff1.write(result.getBytes());
			index ++;
			buff1.flush();
			out.close();
			buff1.close();
		}catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	public void visit(Page page) {
		// TODO Auto-generated method stub
		FileOutputStream out = null; 
		BufferedOutputStream buff1=null;  
		String contentFile = "D:/jave-prj/test/"+index+".txt";
		String linkFile = "D:/jave-prj/test/link_"+index+".txt";
		write2File(page.getContent(), contentFile);
		write2File(page.getLinks().toString(), linkFile);
	}

	public void onError(Url errorUrl, Status statusError) {
		// TODO Auto-generated method stub
		
	}

	public boolean followUrl(Url url) {
		// TODO Auto-generated method stub
		if(checkVisitor == null) {
			checkVisitor = new SimpleCheckVisitor();
		}
		return checkVisitor.match(visitorRule, url);
	}

}
