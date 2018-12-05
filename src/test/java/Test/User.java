package Test;

import java.util.Date;
import java.util.List;


import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSON;

/**
 * 对象传递 传的是引用，方法外和方法内指向的是同一块地址
 * 值传递 传的拷贝的值，方法外和方法内没有任何的关系
 * 
 * @author jzj
 * @date 2018年10月24日 下午3:39:51
 * @desc
 */
public class User {
	
	private int id ;
	
	private boolean isHappy;
	
	private User.Info info;
	
	private User.InfoTest infoTest;
	
	private List<User.Info> infos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public User.InfoTest getInfoTest() {
		return infoTest;
	}

	public void setInfoTest(User.InfoTest infoTest) {
		this.infoTest = infoTest;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}
	
	
	
	public boolean isHappy() {
		return isHappy;
	}

	public void setHappy(boolean isHappy) {
		this.isHappy = isHappy;
	}

	public List<User.Info> getInfos() {
		return infos;
	}

	public void setInfos(List<User.Info> infos) {
		this.infos = infos;
	}

	public static class InfoTest {
		
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
		@Override
		public String toString(){
			return JSON.toJSONString(this);
		}

	}


	public static class Info {
		
		private int age;
		
		private String name;
		
		private Date birthday;

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public Date getBirthday() {
			return birthday;
		}

		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}
		
		@Override
		public String toString(){
			return JSON.toJSONString(this);
		}

	}
	
	public static void main(String[] args) {
		User u1 = new User();
		u1.setId(1);
		Info info1 = new Info();
		info1.setAge(13);
		info1.setName("贾紫君");
		u1.setInfo(info1);
		
		
		test3(u1);
		System.out.println(u1.getId());
		
		User u2 = new User();
		
		test3(info1.getName());
		System.out.println(info1.getName());
		
//		u2.setInfo(u1.getInfo());
//		System.out.println("==u2=="+u2.getInfo().getAge());
//		
//		u2.getInfo().setAge(21);
//		System.out.println("==u1会不会变=="+u1.getInfo().getAge());
//		
//		u1.getInfo().setAge(23);
//		System.out.println("==u2会不会变=="+u2.getInfo().getAge());
//		
//		/********************************************************/
//		
//		u2.setId(u1.getId());
//		System.out.println("==u2=="+u2.getId());
//		
//		u2.setId(2);
//		System.out.println("==u1会不会变=="+u1.getId());
//		
//		u1.setId(3);
//		System.out.println("==u2会不会变=="+u2.getId());
		
		/********************************************************/
		
		BeanUtils.copyProperties(u1, u2);
		System.out.println(u2.getId()+"--"+u2.getInfo().getName());
		
		u1.getInfo().setName("王越");
		System.out.println(u2.getId()+"--"+u2.getInfo().getName());
		
		u2.setInfo(u1.getInfo());
		
//		u2.setInfo(null); //若将u2的info指向null，u2.getInfo()则是null，u1.getInfo()还是原来的地址值。u2.setInfo(null)不能理解为将info的值变为null，一个对象是不能凭空消失的
//		u1.setInfo(null);
		u2.getInfo().setAge(25);
		System.out.println(u2.getInfo()+"--"+u1.getInfo());
		
		/*******************************************************/
		test(u2);
		System.out.println("-----1-----"+u2.getInfo().getName());
		test1(u2);
		System.out.println(u2.getId()+"--"+u2.getInfo().getName());
	}

	private static void test3(User u1) {
		u1.setId(234);
		
	}

	private static void test3(String name) {
		name = "hha";
		System.out.println(name);
		
	}

	private static void test(User u2) {
		User user = new User();
		user.setInfo(u2.getInfo());
		user.getInfo().setName("hahhaha");
		System.out.println("-----1-----"+user.getInfo().getName()+"---"+u2.getInfo().getName());
	}

	private static void test1(User u2) {
		u2.setId(100);
		u2.getInfo().setName("哇哈哈");
		System.out.println(u2.getId()+"--"+u2.getInfo().getName());
	}
}
