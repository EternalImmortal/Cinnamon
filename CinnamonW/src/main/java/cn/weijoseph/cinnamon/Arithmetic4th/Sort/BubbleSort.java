package cn.weijoseph.cinnamon.Arithmetic4th.Sort;

import cn.weijoseph.cinnamon.Arithmetic4th.AnnotationOfWRJ.ForClass;
import cn.weijoseph.cinnamon.Arithmetic4th.AnnotationOfWRJ.TimeCount;
import cn.weijoseph.cinnamon.Arithmetic4th.Base.BaseArrayMethod;
import org.junit.Test;

@ForClass
public class BubbleSort {
    BaseArrayMethod baseArrayMethod = new BaseArrayMethod();

    @TimeCount(name = "冒泡排序升序")
    public int[] bubbleSortAsc(int[] array) {

        for(int i = 0; i < array.length-1; i++) {
            for(int j = 0; j < array.length-1 - i; j++) {
                if (array[j] > array[j+1]) {
                    int k = array[j];
                    array[j] = array[j+1];
                    array[j+1] = k;
                }
            }

        }
        return array;
    }

    @TimeCount(name = "冒泡排序升序2")
    public int[] bubbleSortAsc2(int [] array) {
        boolean changed;
        do {
            changed = false;
            for(int i = 0; i < array.length-1; i++) {
                if(array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    changed = true;
                }
            }
        }while(changed);
        return array;
    }


    @Test
    public int[] bubbleSortRandom() {
        int[] array = bubbleSortAsc2(baseArrayMethod.produceRandomArray(50,100));
        baseArrayMethod.printArray(array);
        return array;
    }
}
