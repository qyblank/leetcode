/*
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data*/
/**//*

@AllArgsConstructor
@NoArgsConstructor
class aaa {
    private final String a= "aa";
    private String name;
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // 使用foreach循环遍历并尝试修改元素，会抛出ConcurrentModificationException异常
        for (Integer num : list) {
            list.set(list.indexOf(num), num * 2);
        }

        Map<String ,Integer> map =new HashMap<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            
        }
        System.out.println(list);
    }
}
*/
