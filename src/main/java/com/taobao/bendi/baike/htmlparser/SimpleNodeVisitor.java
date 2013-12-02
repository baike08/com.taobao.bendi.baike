package com.taobao.bendi.baike.htmlparser;

import java.util.Vector;

import org.htmlparser.Tag;
import org.htmlparser.Text;
import org.htmlparser.visitors.NodeVisitor;

public class SimpleNodeVisitor extends NodeVisitor {
	
	private String text;
	private String tagName;
	private Vector attriVect;
	
	public SimpleNodeVisitor ()
	{
	}
	 
	public void visitTag (Tag tag)
	{
		this.tagName = tag.getTagName();
		attriVect = tag.getAttributesEx();
		//System.out.println ("\n" + tag.getTagName () + tag.getStartPosition ());
	}
	 
	public void visitStringNode (Text string)
	{
		this.text = string.getText();
		//System.out.println (string.getText());
	}
	
	public String getText() {
		return text;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Vector getAttriVect() {
		return attriVect;
	}

	public void setAttriVect(Vector attriVect) {
		this.attriVect = attriVect;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
