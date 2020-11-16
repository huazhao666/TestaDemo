import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-10-25
 * Time : 15:31
 */
public class Re {
    public static void main1 (String[] args){
        int[] array = {1,23,4,4,45,5,0,0};
        int[] arr = {12,3};
        int[] abc =  Arrays.copyOf(array,4);
        System.arraycopy(arr,0,array,6,2);
        System.out.println(Arrays.toString(array));
       Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
    public  static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int n = nums1.length;
        int m = nums2.length;
        int[] array = new int[n+m];
        System.arraycopy(nums1,0,array,0,n);
        System.arraycopy(nums2,0,array,n ,m);
        Arrays.sort(array);
        if(( n + m  ) % 2 != 0){
            int s = (n+m) / 2;
            return array[s];
        }else{
            int a = (n+m ) / 2;
            return(array[a] + array[a-1])*1.0 / 2;
        }
    }
    public static void main (String[] args){
        int[] nums1 = {1,3};
        int[] nums2 = {2,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

}
