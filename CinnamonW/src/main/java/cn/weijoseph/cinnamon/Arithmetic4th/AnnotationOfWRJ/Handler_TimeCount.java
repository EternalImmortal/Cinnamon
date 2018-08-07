package cn.weijoseph.cinnamon.Arithmetic4th.AnnotationOfWRJ;

import cn.weijoseph.cinnamon.Arithmetic4th.Base.BaseArrayMethod;
import cn.weijoseph.cinnamon.Arithmetic4th.DailyTest.TestAES;
import cn.weijoseph.cinnamon.Arithmetic4th.Sort.BubbleSort;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author weirenjie
 * @date 2018/7/19
 */
public class Handler_TimeCount {

    @Test
    public void Test() {
        BubbleSort bubbleSort = new BubbleSort();
        BaseArrayMethod baseArrayMethod = new BaseArrayMethod();

        // Boolean hasForClass = BubbleSort.class.isAnnotationPresent(ForClass.class);

        try {
            Method[] methods = BubbleSort.class.getMethods();
            if (methods != null) {
                for (Method method : methods) {
                    if (method.isAnnotationPresent(TimeCount.class)) {
                        TimeCount timeCount = method.getAnnotation(TimeCount.class);
                        System.out.println("被TimeCount注解的方法名称: " + timeCount.name());
                        int[] arrays = baseArrayMethod.produceRandomArray(10000, 100);
                        Long startTime = System.currentTimeMillis();
                        method.invoke(bubbleSort, arrays);
                        Long endTime = System.currentTimeMillis();
                        System.out.println("该方法的运行时间为：" + (endTime - startTime) + "ms");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void AESTimeTest() {
        TestAES testAES = new TestAES();
        String data = "{\"recordType\":1,\"targetId\":\"746022\",\"targetType\":0,\"unitId\":\"914133\",\"startTime\":1533626596717,\"endTime\":1533626616720}";
        String key = "learntime_submit";
        String signature = "egVoffl4VYBlqFkVk1ijZzGuLnvIBLHKZyzu95g+FkQJrPhGJ5a3ImKAhOTgFD9wdDEYILjilFTYKsAYNFuj4fY9GQhXshMpWvRZ/vVi78juaC3uSo4smqyOzuNstMiRR0khvkLSDt3068WY3heJUGIgWywTcAbldmwbIbQqOtA=";
        try {
            Method[] methods = TestAES.class.getMethods();
            if (methods != null) {
                for (Method method : methods) {
                    if (method.isAnnotationPresent(TimeCount.class)) {
                        TimeCount timeCount = method.getAnnotation(TimeCount.class);
                        System.out.println("被TimeCount注解的方法名称: " + timeCount.name());
                        Long startTime = System.currentTimeMillis();
                        method.invoke(testAES, signature, key);
                        Long endTime = System.currentTimeMillis();
                        System.out.println("该方法的运行时间为：" + (endTime - startTime) + "ms");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
