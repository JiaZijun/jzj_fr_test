package Test;

import java.io.InputStream;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.dom4j.ElementPath;
import org.dom4j.io.SAXReader;

public class ElementHandlerTest {
	
	 public static void main(String[] args)
	    {
	        try {
	        	SAXReader saxReader = new SAXReader();
		        saxReader.addHandler("/students/student", new StudentHandler());
	        	InputStream is = ElementHandlerTest.class.getResourceAsStream("student.xml");  
	            saxReader.read(is);
	        }
	        catch (DocumentException e){
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }

	    private static class StudentHandler implements ElementHandler{

			public void onStart(ElementPath path) {
				Element elt = path.getCurrent();
	            System.out.println("Found student : "+elt.attributeValue("sn"));
	            path.addHandler("name",new NameHandler());
	            path.addHandler("age",new NameHandler());
				
			}

			public void onEnd(ElementPath path) {
				  path.removeHandler("name");
				
			}
	        

	    }

	    private static class NameHandler implements ElementHandler{
	    	//不要获取文本内容。
	        public void onStart(ElementPath path) {
	            System.out.println(path.getPath());
	        }
	        
	       //读取文本内容
	        public void onEnd(ElementPath path) {
	            Element elt = path.getCurrent();
	            System.out.println(elt.getName()+" : "+elt.getText());

	        }

	    }
}
