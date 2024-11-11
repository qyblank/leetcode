import org.junit.Test;

import java.util.Arrays;

public class codeTest {
    Solution solution=new Solution();
    @Test
    public void test(){

            int[] a={3,0,6,1,5};
        int b = solution.hIndex(a);
        System.out.println(b);
    }
}
