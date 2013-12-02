package com.taobao.bendi.baike.rule;

import net.vidageek.crawler.Url;

public class CheckFollow {
	
	public static boolean isFollow(VisitorRule rule, Url url) {
		if(rule == null) {
			return false;
		}
		// 先确定是否在 排除规则里
		rule.getDisAllow();
		return true;
	}

}
