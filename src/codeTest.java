/*
import org.junit.Test;
import suixiang.数组.螺旋矩阵.Solution;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class codeTest {
    Solution solution=new Solution();
    @Test
    public void test(){
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
          String s="a";
          String t="aa";
        List<Integer> list = solution.spiralOrder(array);
        System.out.println(list);
        Set a=new HashSet();

    }

    @Test
   public void test2() throws Exception, IllegalAccessException, NoSuchMethodException {

        aaa a = new aaa("aaa");
        Class<? extends aaa> aClass = a.getClass();

        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        String s = (String)name.get(a);
        name.set(a,"bbb");
        System.out.println(a.getName());

        Method getName = aClass.getMethod("getName", null);
        String invoke = (String) getName.invoke(a,null);
        System.out.println(invoke);

    }




}
*/
