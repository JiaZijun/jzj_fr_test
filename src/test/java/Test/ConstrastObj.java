package Test;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.w3c.dom.ls.LSInput;

import Test.User.Info;
import Test.User.InfoTest;

import java.util.Set;

/**
 * 类说明：利用反射比较两个实体的有哪些属性值不同
 * @author zwq1105
 * @version 创建时间：2017-3-4 下午16:30:36
 */
public class ConstrastObj {
	
	public static void main(String[] args) {
		try {
			test2();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static boolean compareFields1(String o1, String o2){
		if(o1.equals(o2)){
			return true;
		}
		return false;
	}	
	
	public static void test2() throws ParseException {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		User u1 = new User();
		u1.setId(15);
		u1.setHappy(true);
		u1.setInfos(new ArrayList<User.Info>());
		
		Info info1 = new Info();
		info1.setAge(23);
		info1.setName("贾紫君");
		info1.setBirthday(sdf.parse("1996-10-15"));
		
		Info info11 = new Info();
		info11.setAge(23);
		info11.setName("贾紫君");
		
		u1.setInfo(info1);
		u1.getInfos().add(info1);
		u1.getInfos().add(info11);
		
		InfoTest infoTest = new InfoTest();
		infoTest.setName("哈哈");
		u1.setInfoTest(infoTest);
		
		User u2 = new User();
		u2.setId(15);
		u2.setHappy(true);
		u2.setInfos(new ArrayList<User.Info>());
		
		Info info2 = new Info();
		info2.setAge(23);
		info2.setName("贾紫君");
		info2.setBirthday(sdf.parse("1995-10-15"));
		
		Info info22 = new Info();
		info22.setAge(23);
		info22.setName("贾紫君");
		
		u2.setInfo(info2);
		u2.getInfos().add(info2);
		u2.getInfos().add(info22);
		u2.setInfoTest(new User.InfoTest());
		
		
		// 比较s1和s2不同的属性值，其中id忽略比较
		Map<String, List<Object>> compareResult = compareFields(u1, u2, new String[]{});
		System.out.println("s1和s2共有" + compareResult.size() + "个属性值不同（不包括id）");
		System.out.println("其中：");
		Set<String> keySet = compareResult.keySet();
		for(String key : keySet){
			List<Object> list = compareResult.get(key);
			System.out.println(">>>  s1的" + key + "为" + list.get(0) + "，s2的" + key + "为" + list.get(1));
		}
	}
	
	
	
	/**
	 * 比较两个实体属性值，返回一个map以有差异的属性名为key，value为一个list分别存obj1,obj2此属性名的值
	 * @param obj1 进行属性比较的对象1
	 * @param obj2 进行属性比较的对象2
	 * @param ignoreArr 选择忽略比较的属性数组
	 * @return 属性差异比较结果map
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, List<Object>> compareFields(Object obj1, Object obj2, String[] ignoreArr) {
		try{
			Map<String, List<Object>> map = new HashMap<String, List<Object>>();
			List<String> ignoreList = null;
			if(ignoreArr != null && ignoreArr.length > 0){
				// array转化为list
				ignoreList = Arrays.asList(ignoreArr);
			}
			if (obj1.getClass() == obj2.getClass()) {// 只有两个对象都是同一类型的才有可比性
				Class clazz = obj1.getClass();
				// 获取object的属性描述
				PropertyDescriptor[] pds = Introspector.getBeanInfo(clazz,
						Object.class).getPropertyDescriptors();
				for (PropertyDescriptor pd : pds) {// 这里就是所有的属性了
					String name = pd.getName();// 属性名
					if(ignoreList != null && ignoreList.contains(name)){// 如果当前属性选择忽略比较，跳到下一次循环
						continue;
					}
					Method readMethod = pd.getReadMethod();// get方法
					// 在obj1上调用get方法等同于获得obj1的属性值
					Object o1 = readMethod.invoke(obj1);
					// 在obj2上调用get方法等同于获得obj2的属性值
					Object o2 = readMethod.invoke(obj2);
					System.out.println(name+"--o1--"+o1+"--o2--"+o2);
//					if(o1 instanceof Timestamp){
//						o1 = new Date(((Timestamp) o1).getTime());
//					}
//					if(o2 instanceof Timestamp){
//						o2 = new Date(((Timestamp) o2).getTime());
//					}
//					if(o1 == null && o2 == null){
//						continue;
//					}else if(o1 == null && o2 != null){
//						List<Object> list = new ArrayList<Object>();
//						list.add(o1);
//						list.add(o2);
//						map.put(name, list);
//						continue;
//					}
//					if (!o1.equals(o2)) {// 比较这两个值是否相等,不等就可以放入map了 ，equals比较对象的时候，比较的是地址，必须重写对象的equals和hashCode方法
//						List<Object> list = new ArrayList<Object>();
//						list.add(o1);
//						list.add(o2);
//						map.put(name, list);
//					}
					
					  //将对象调用toString方法在进行比较，只需重写toString方法
					  String s1 = o1 == null ? "" : o1.toString();//避免空指针异常
	                  String s2 = o2 == null ? "" : o2.toString();//避免空指针异常
                     if (!s1.equals(s2)) {
						List<Object> list = new ArrayList<Object>();
						list.add(o1);
						list.add(o2);
						map.put(name, list);
                     }
				}
			}
			return map;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}
 
/**
 * 学生orm
 * @author zwq1105
 */
class Student{
	private String id;
	private String name;
	private int age;
	private String city;
	
	public Student(String id, String name, int age, String city) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
