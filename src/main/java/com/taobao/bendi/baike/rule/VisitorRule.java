package com.taobao.bendi.baike.rule;

import java.io.Serializable;
import java.util.List;

/**
 * ���ʹ������
 * @author baike.lwb
 *
 */

public class VisitorRule implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5617215969449922433L;

	/**
	 * ���
	 */
	private int depth;
	
	/**
	 * �����������ִ�еĹ���
	 */
	private List<VRule> allow;	
	
	private boolean defaultRule = true;
	
	/**
	 * �ܾ���������ִ�еĹ���
	 */
	private List<VRule> disAllow;

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public List<VRule> getAllow() {
		return allow;
	}

	public void setAllow(List<VRule> allow) {
		this.allow = allow;
	}

	public List<VRule> getDisAllow() {
		return disAllow;
	}

	public void setDisAllow(List<VRule> disAllow) {
		this.disAllow = disAllow;
	}

	public boolean isDefaultRule() {
		return defaultRule;
	}

	public void setDefaultRule(boolean defaultRule) {
		this.defaultRule = defaultRule;
	}

	@Override
	public String toString() {
		return "VisitorRule [depth=" + depth + ", allow=" + allow
				+ ", defaultRule=" + defaultRule + ", disAllow=" + disAllow
				+ "]";
	}
}
