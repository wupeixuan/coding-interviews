package Array;

/**
 * 数组中重复的数字
 *在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 思路：
 * 数组中的数字都在0到n-1的数字范围内。如果数组中没有重复出现的数字，那么当数组排序后数字i就出现在数组中下标为i的元素处。那么数组中如果存在重复数字的话，有些位置的对应的数字就没有出现，而有些位置可能存在多个数字。数组用numbers表示
 那么我们重排这个数组。从第0个元素开始。
 1、比较numbers[i]和i的值，如果i与numbers[i]相等，也就是对数组排序后，numbers[i]就应该在对应的数组的第i个位置处，那么继续判断下一个位置。
 2、如果i和numbers[i]的值不相等，那么判断以numbers[i]为下标的数组元素是什么。
 2.1、如果numbers[numbers[i]]等于numbers[i]的话，那么就是说有两个相同的值了，重复了。找到了重复的数字
 2.2、如果numbers[numbers[i]]不等于numbers[i]的话，那么就将numbers[numbers[i]]和numbers[i]互换。继续进行1的判断。
 3、循环退出的条件是直至数组最后一个元素，仍没有找到重复的数字，数组中不存在重复的数字。
 */
public class Solution02 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public static void main(String[] args) {
        int[] arr ={2,3,1,0,2,5,3};
        int[] duplication = {-1};
        duplicate(arr,arr.length,duplication);
        System.out.println(duplication[0]);
    }
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length<=0||numbers==null){
            return false;
        }
        //判断数组数据是否合法
        for(int i=0;i<length;i++){
            if(numbers[i]<0||numbers[i]>length-1){
                return false;
            }
        }

        for(int i=0;i<length;i++){
            while(numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }else{
                    //交换numbers[i]和numbers[numbers[i]]
                    int temp = numbers[i];
                    numbers[i] = numbers[temp];
                    numbers[temp] = temp;
                }
            }
        }
        return false;
    }
}
