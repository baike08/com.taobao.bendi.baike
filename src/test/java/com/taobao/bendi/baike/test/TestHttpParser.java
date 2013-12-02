package com.taobao.bendi.baike.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.visitors.NodeVisitor;

import com.taobao.bendi.baike.htmlparser.SimpleNodeVisitor;

public class TestHttpParser {
	
	 private static String ENCODE = "UTF-8";

	    /**
	     * @param args
	     */
	    public static void main(String[] args) {
	    	TestHttpParser test = new TestHttpParser();
	        // String url =
	        // "http://www.google.com.hk/search?hl=zh-CN&source=hp&q=nero9%E5%88%BB%E5%BD%95ape&aq=f&aqi=&aql=&oq=&gs_rfai=";
	        String url = "http://www.baidu.com/";
	        test.testNodeFilter(url);
	        String s = "{\"contact\":\"lifemall04\",\"createtime\":\"2013-09-04 15:31:45\",\"diningtime\":\"2013-09-04 15:31:45\",\"items\":\"[{\"count\":1,\"id\":\"00356\",\"name\":\"�����ˮ��\",\"price\":20.00}, {\"count\":1,\"id\":\"00020\",\"name\":\"з�Ӹ�����\",\"price\":5.00}, {\"count\":1,\"id\":\"00541\",\"name\":\"����޲��ˮѼ��\",\"price\":5.00}, {\"count\":1,\"id\":\"00597\",\"name\":\"���҆�����ˬ��\",\"price\":2.00}, {\"count\":1,\"id\":\"00416\",\"name\":\"��ʱ��Ʒ\",\"price\":5.00}, {\"count\":1,\"id\":\"00910\",\"name\":\"����ʫXO350m\",\"price\":1.00}, {\"count\":1,\"id\":\"00003\",\"name\":\"��Ƥ��ź��\",\"price\":5.00}, {\"count\":1,\"id\":\"00539\",\"name\":\"˫ѩ�Һ�����\",\"price\":6.00}]\",\"mobile\":\"18258830635\",\"note\":\"\",\"orderid\":\"21049\",\"people\":13,\"realprice\":\"47.00\",\"storeid\":\"1234\",\"tablenumber\":\"1033\",\"totalprice\":\"49.00\"}";
	        String t="{\"contact\":\"life01\",\"createtime\":\"2013-09-04 11:30:30\",\"diningtime\":\"2013-09-04 11:30:30\",\"items\":\"[{\"itemcount\":1,\"itemid\":\"00356\",\"itemname\":\"�����ˮ��\",\"price\":20.00,\"skucode\":\"\",\"skuinfo\":\"\"}, {\"itemcount\":1,\"itemid\":\"00539\",\"itemname\":\"˫ѩ�Һ�����\",\"price\":6.00,\"skucode\":\"\",\"skuinfo\":\"\"}, {\"itemcount\":1,\"itemid\":\"00003\",\"itemname\":\"��Ƥ��ź��\",\"price\":5.00,\"skucode\":\"\",\"skuinfo\":\"\"}, {\"itemcount\":1,\"itemid\":\"00910\",\"itemname\":\"����ʫXO350m\",\"price\":1.00,\"skucode\":\"\",\"skuinfo\":\"\"}, {\"itemcount\":1,\"itemid\":\"00597\",\"itemname\":\"���҆�����ˬ��\",\"price\":2.00,\"skucode\":\"\",\"skuinfo\":\"\"}, {\"itemcount\":1,\"itemid\":\"00541\",\"itemname\":\"����޲��ˮѼ��\",\"price\":5.00,\"skucode\":\"\",\"skuinfo\":\"\"}, {\"itemcount\":1,\"itemid\":\"00416\",\"itemname\":\"��ʱ��Ʒ\",\"price\":5.00,\"skucode\":\"\",\"skuinfo\":\"\"}, {\"itemcount\":1,\"itemid\":\"00007\",\"itemname\":\"��˿���۾�\",\"price\":2.00,\"skucode\":\"\",\"skuinfo\":\"\"}, {\"itemcount\":1,\"itemid\":\"00020\",\"itemname\":\"з�Ӹ�����\",\"price\":5.00,\"skucode\":\"\",\"skuinfo\":\"\"}]\",\"mobile\":\"15818588134\",\"note\":\"\",\"orderid\":\"21006\",\"people\":2,\"realprice\":\"49.00\",\"storeid\":\"1234\",\"storename\":\"����������ʳ��ʳ��(�Ƽ����õ�)\",\"tablenumber\":\"016\",\"totalprice\":\"51.00\"}";
	    	System.out.println("message = " + s.length());
	    //    test.testInitParser();
	    }

	    /**
	     * ���ֳ�ʼ���ķ���
	     */
	    private void testInitParser() {
	        try {
	            Parser parser1 = new Parser();
	            parser1.setURL("http://www.baidu.com");
	            parser1.setEncoding(parser1.getEncoding());

	            // url ��ʼ���ķ���
	            HttpURLConnection.setFollowRedirects(true);
	            URL netUrl = new URL("http://www.baidu.com");
	            HttpURLConnection con = (HttpURLConnection) netUrl.openConnection();
	            con.setInstanceFollowRedirects(false);
	            con.connect();
	            Parser parser2 = new Parser(con);

	            // �����ַ�����ʼ��
	            String htmlString = this.readHtmlFile("d:/test/test.html");
	            Parser parser3 = Parser.createParser(htmlString, ENCODE);

	            // �����ַ�����ʼ��
	            String htmlStr1 = "<html><head><title>Test</title>"
	                    + "<link href=��/test01/css.css' text='text/css' rel='stylesheet'/>"
	                    + "</head><body><div><a href='www.baidu.com'  target='_blank'>baidu</a></div>"
	                    + "<div><a href='www.sina.com' target='_blank'>sina</a></div></body></html>";
	            Parser parser4 = new Parser(htmlStr1);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * NodeFilter
	     * @param url
	     */
	    private void testNodeFilter(String url) {
	    	
	    	System.out.println("NodeFilter start...");
	        try {
	            HttpURLConnection.setFollowRedirects(true);
	            URL netUrl = new URL(url);
	            HttpURLConnection con = (HttpURLConnection) netUrl.openConnection();
	            con.setInstanceFollowRedirects(false);
	            con.connect();
	            Parser parser = new Parser(con);
	            parser.setEncoding(parser.getEncoding());
	            
	            SimpleNodeVisitor nodeVisitor = new SimpleNodeVisitor();
	            NodeFilter filter = new TagNameFilter("A");
	            NodeList list = parser.extractAllNodesThatMatch(filter);
	            for (int i = 0; i < list.size(); i++) {
	                System.out.println(list.elementAt(i).toHtml());
	                System.out.println(list.elementAt(i).getText());
	                list.elementAt(i).accept(nodeVisitor);
	                System.out.println(nodeVisitor.getText());
	                System.out.println(nodeVisitor.getAttriVect());
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        System.out.println("NodeFilter end");
	    }

	    /**
	     * ��ȡHTML�ļ�
	     * @param htmlFileName
	     * @return
	     */
	    private String readHtmlFile(String htmlFileName) {
	        BufferedReader bis = null;
	        try {
	            bis = new BufferedReader(new InputStreamReader(new FileInputStream(
	                    new File(htmlFileName)), ENCODE));
	            StringBuffer htmlsb = new StringBuffer();
	            String readTemp;
	            while ((readTemp = bis.readLine()) != null) {
	                htmlsb.append(readTemp);
	            }
	            bis.close();
	            return htmlsb.toString();
	        } catch (Exception e) {
	            return null;
	        } finally {
	            if (null != bis) {
	                try {
	                    bis.close();
	                } catch (IOException ioe) {
	                    ioe.printStackTrace();
	                }
	            }
	        }
	    }

}
