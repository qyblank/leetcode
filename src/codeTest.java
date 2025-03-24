import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class codeTest {
 /*   Solution solution=new Solution();*/
    @Test
    public void test(){
      /*     String a="a";
           String b="aa#a";
           solution.backspaceCompare(a,b);*/
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
