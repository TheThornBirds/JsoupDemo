package cn.wuchen;

/**
 * Created by wuchen on 2017/9/19.
 */
public class ParameterTest {

    public static void main(String[] args){
        System.out.println(ParameterTest.Count(1,2));
    }

    public static int Count(int... a){
        int sum = 0;
        for (int x = 0; x < a.length; x++) {
            sum += a[x];
        }
        return sum;
    }

}
