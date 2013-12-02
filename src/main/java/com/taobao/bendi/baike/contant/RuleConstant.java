package com.taobao.bendi.baike.contant;

public enum RuleConstant {
	
	Equal("equal"),				//
	
	Unequal("unequal"),			//
	
	Match("match"),				//
	
	Unmatch("unmatch");			// 
	
	private String ruleConstant;  
	
	private RuleConstant(String rc) {
		this.ruleConstant = rc;
	}
	
	public static RuleConstant getRuleConstant(String rc) {
		if("equal".equals(rc)) {
			return RuleConstant.Equal;
		}
		if("unequal".equals(rc)) {
			return RuleConstant.Unequal;
		}
		if("match".equals(rc)) {
			return RuleConstant.Match;
		}
		if("unmatch".equals(rc)) {
			return RuleConstant.Unmatch;
		}
		return null;
	}

}
