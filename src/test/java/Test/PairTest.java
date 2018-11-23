package Test;

import org.apache.commons.lang3.tuple.Pair;

/**
 * pair类适用于方法返回两个数据的
 * 
 * @author jzj
 * @date 2018年10月15日 上午11:11:51
 * @desc
 */
public class PairTest {
	public static class Info {
		
		private int age;
		
		private String name;

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

	}
	
	public static void main(String[] args) {
		final Info info1 = new Info();
		info1.setAge(23);
		info1.setName("贾紫君");
		
		final Info info2 = new Info();
		info2.setAge(23);
		info2.setName("王越");
		
		Pair<Info, Info> pair = Pair.of(info1, info2);
		
		System.out.println(pair.getLeft().getName()+"--"+pair.getRight().getName()+"--"+pair.getKey()+"--"+pair.getValue());
	}


	
}
