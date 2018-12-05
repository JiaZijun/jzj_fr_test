package Test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fr.test.service.design.model.CarFactory;
import com.fr.test.service.design.model.Ocar;
import com.fr.test.service.design.model.Wcar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"}) 
public class CarModelTest {
	
	@Test
	public void  test(){
		
		CarFactory.carType("ocar").exceut();
		
		
	}

}
