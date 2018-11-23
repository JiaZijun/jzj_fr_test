package Test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String... args) {
		// 集合对象，列表[a, b, c]
		List<String> testParam = new ArrayList<String>();
		testParam.add("a");
		testParam.add("b");
		testParam.add("c");
		System.out.println("Old: " + testParam.toString() + "\r\n");
 
		add(testParam);
		System.out.println("add: " + testParam.toString() + "\r\n");
		
		// 引用(地址)传值，并直接修改testParam指向对象的值
		change(testParam);
		System.out.println("Change1: " + testParam.toString() + "\r\n");
 
		testParam.add("a");
 
		// 引用(地址)传值，修改指向对象之后再将地址返回
		testParam = change2(testParam);
		System.out.println("Change2: " + testParam.toString() + "\r\n");
 
		// 集合对象变为[b, c, d, e]
		testParam.add("d");
		testParam.add("e");
 
		// 引用(地址)传值，方法内部new新集合对象并将地址赋给方法局部参数，
		// 并不改变testParam的值，testParam仍然指向原地址
		sort(testParam);
		System.out.println("sort1: " + testParam.toString() + "\r\n");
		// 引用(地址)传值，方法内部new新集合对象并将地址赋给方法局部参数，
		// 并将新地址返回，再赋值给testParam，因此testParam指向的对象发生改变
		testParam = sort2(testParam);
		System.out.println("sort2: " + testParam.toString() + "\r\n");
	}
 
	private static void add(List<String> testParam) {
		testParam.add("ddd");
		
	}

	public static void change(List<String> param) {
		if (param.contains("a"))
			param.remove("a");
	}
 
	public static List<String> change2(List<String> param) {
		if (param.contains("a"))
			param.remove("a");
		return param;
	}
 
	public static void sort(List<String> param) {
		List<String> newParam = new ArrayList<String>();
		for (int i = param.size() - 1; i >= 0; i--) {
			newParam.add(param.get(i));
		}
		param = newParam;
	}
 
	public static List<String> sort2(List<String> param) {
		List<String> newParam = new ArrayList<String>();
		for (int i = param.size() - 1; i >= 0; i--) {
			newParam.add(param.get(i));
		}
		return newParam;
	}


}
