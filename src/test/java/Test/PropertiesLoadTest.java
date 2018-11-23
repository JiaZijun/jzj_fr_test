package Test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fr.test.bean.SupplierConfig;
import com.fr.test.bean.SystemConfig;

/**
 * 第一种方式：测试读取配置文件属性
 * 1.新增spring-config.xml文件
 * 2.在spring.xml中引入suppier-config.xml
 * 
 * 第二种方式：在spring.xml中加入配置属性文件的读取
     <context:property-placeholder location="classpath*:*.properties" ignore-unresolvable="true" file-encoding="UTF-8"/>
 * 
 * @author jzj
 * @date 2018年8月23日
 * @time 下午5:51:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class PropertiesLoadTest {
	
	@Resource
	private SupplierConfig supplierConfig;
	
	@Resource
	private SystemConfig systemConfig;
	
	@Test
	public void propertiesLoad(){
		
		System.out.println(supplierConfig.getSystemIdentity());
		System.out.println(supplierConfig.getPassword());
		System.out.println(supplierConfig.getPseudoCityCode());
		System.out.println(systemConfig.getHost());
	}
	

}
