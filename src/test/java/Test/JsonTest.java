package Test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fr.test.service.test.JsonTestChild;
import com.fr.test.service.test.JsonTestService;

import Test.User.Info;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})  
//@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/springmvc-servlet.xml"})  
public class JsonTest {
	

	
	@Test
	public void test1(){
		System.out.println("hello World !");

	    JsonTestService s = new JsonTestChild();

		s.testJson();

		System.out.println("==================");

		JsonTestChild c = new JsonTestChild();

		c.testJson();


		//	new JsonTestService("哈哈");

	}
	
	public static void main(String[] args) {
		User u = new User();
		u.setId(90);
		Info info =new Info();
		info.setName("贾紫君");
		u.setInfo(info);
		String s= JSON.toJSONString(u);
		
		
		JSONObject ob = JSONObject.parseObject(s);
		Info fo = ob.getObject("info", Info.class);
		System.out.println(fo.getName()+"--"+u.getInfo().getName()+"--"+s);
		test(fo);
		u.setInfo(fo);
		s=JSON.toJSONString(u);
		System.out.println(fo.getName()+"--"+u.getInfo().getName()+"--"+s);
	}

	private static void test(Info fo) {
		fo.setName("望月");
	}
	

}
