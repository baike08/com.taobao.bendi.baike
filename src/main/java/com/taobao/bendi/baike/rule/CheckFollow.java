package com.taobao.bendi.baike.rule;

import net.vidageek.crawler.Url;

public class CheckFollow {
	
	public static boolean isFollow(VisitorRule rule, Url url) {
		if(rule == null) {
			return false;
		}
		// ��ȷ���Ƿ��� �ų�������
		rule.getDisAllow();
		return true;
	}

}
