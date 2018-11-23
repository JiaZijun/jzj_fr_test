package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.dom4j.ElementPath;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class ReadXmlByDom4J implements ElementHandler{
	
	SAXReader reader;  
	public ReadXmlByDom4J() {
		 // test.xml文件跟类放在同一目录下  
        try {  
            InputStream is = ReadXmlByDom4J.class.getResourceAsStream("test.xml");   
            reader = new SAXReader();  
            reader.setDefaultHandler(this);  
            reader.read(is);  
        } catch (DocumentException e) {  
            e.printStackTrace();  
        }  
	}

	public void onStart(ElementPath elementPath) {
		// TODO Auto-generated method stub
		
	}

	public void onEnd(ElementPath elementPath) {
		 Element e = elementPath.getCurrent(); //获得当前节点  
	        if(e.getName().equals("PARAM_TIMESTAMP"))  
	            System.out.println("解析到时间:"+e.getText());  
	        else if(e.getName().equals("CITYINFO")){  
	            System.out.printf("解析到CITYINFO,属性值为：%s,%s,%s/n", e  
	                    .attributeValue("City"), e.attributeValue("Name"), e  
	                    .attributeValue("No"));  
	        }  
	        e.detach(); //记得从内存中移去  
	}
	
	 public static void main(String[] args){  
	        new ReadXmlByDom4J();  
	    }  
	
}
