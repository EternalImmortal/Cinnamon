package cn.weijoseph.cinnamon.Arithmetic4th.Base;

public class BaseArrayMethod {

    public int[] produceRandomArray(int num, int max) {
        // System.out.println("随机数组的大小是："+ num + "\t随机数组的范围是：0到" + max);
        // System.out.print("这个数组是：");
        int[] array = new int[num];
        for(int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*max);
            // System.out.print(array[i] + "\t");
        }
        // System.out.println();
        return array;
    }

    public void printArray(int[] array) {
        System.out.print("\n打印数组：");
        for (int a : array) {
            System.out.print(a + "\t");
        }
    }


}
