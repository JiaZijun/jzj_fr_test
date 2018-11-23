package Test;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Lists;

/**
 * guava包相关测试
 * 
 * @author jzj
 * @date 2018年11月8日 下午5:50:26
 * @desc
 */
public class GuavaTest {
	
	private static final ImmutableSet<String> SET_OF = ImmutableSet.of("aa","bb","cc","aa");
	
	private static final ImmutableList<String> LIST_OF = ImmutableList.of("aa","bb","cc","aa");
	
	private static final List<String> LIST = Lists.newArrayList("aa","bb","cc","dd");
	
	private static final ImmutableList<String> LIST_COPYOF = ImmutableList.copyOf(LIST);			
	
   public static <F> void main(String[] args) {
	   
	 //  guava不可变集合 Immutable
	 System.out.println("--不可变集合set--"+SET_OF.toString());
	 System.out.println("--不可变集合list--"+LIST_OF.toString());
	 System.out.println("--不可变集合list--"+LIST_COPYOF.toString());
	 
	 List<Integer> sortlist = Lists.newArrayList(1,2,5,4,1,3,2,8,0,19);
	 ImmutableSet<Integer> sort = ImmutableSortedSet.copyOf(sortlist);
	 System.out.println("--排序后--"+sort);
	 
	   
	 boolean isTrue = true;
	   
	 List<String> list = Lists.newArrayList();
	 list.add("aa");
	 list.add("bb");
	 //前置条件判断使用Preconditions
	 Preconditions.checkNotNull(list, "list为空");
	 Preconditions.checkState(isTrue, "false");
	 
   }

}
