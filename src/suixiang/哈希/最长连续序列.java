package suixiang.哈希;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 最长连续序列 {
    public int longestConsecutive(int[] nums) {
        int max=0;
        Set<Integer> set=new HashSet<>();
        Set<Integer> used=new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if(used.contains(num)) continue;
            used.add(num);
            int n=0;
            for (int i = num+1; ; i++) {
                if(set.contains(i)) {
                    used.add(i);
                    n++;
                } else break;
            }
            if(n>max) max=n;
        }
        return max;
    }
}
