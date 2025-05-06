package suixiang.哈希.两个数组的交集;

import java.beans.PropertyEditorManager;
import java.util.*;

public class 两个数组的交集Ⅱ {
    public int[] intersect(int[] nums1, int[] nums2) {
        //使用set集合
        Map<Integer,Integer> set1 =new HashMap<>();
        for (int i : nums1) {
              if(set1.containsKey(i)) {
                  set1.put(i,set1.get(i)+1);
              }else {
                  set1.put(i,1);
              }
        }
        List<Integer> list=new ArrayList<>();
        for (int i : nums2) {
            if(set1.containsKey(i)) {
                list.add(i);
                if(set1.get(i)==1) {
                    set1.remove(i);
                }else {
                    set1.put(i,set1.get(i)-1);
                }
            }
        }
        //通过stream流将set集合处理成int数组
        return Arrays.stream(list.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();
    }

}
