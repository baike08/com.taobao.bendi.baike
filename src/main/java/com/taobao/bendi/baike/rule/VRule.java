package com.taobao.bendi.baike.rule;

import java.util.regex.Pattern;

import com.taobao.bendi.baike.contant.RuleConstant;

public class VRule {
	
	private String rule;
	
	private RuleConstant type;
	
	/**
	 * 
	 * @param r
	 * @return
	 */
	public boolean isMatch(String r) {
		if(type == RuleConstant.Equal) {
			return rule.equals(r);
		}else if(type == RuleConstant.Unequal) {
			return !rule.equals(r);
		}else if(type == RuleConstant.Match) {
			return Pattern.matches(rule, r);
		}else if(type == RuleConstant.Unmatch) {
			return !Pattern.matches(rule, r);
		}
		return false;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public RuleConstant getType() {
		return type;
	}

	public void setType(RuleConstant type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "VRule [rule=" + rule + ", type=" + type + "]";
	}
	
	
}
