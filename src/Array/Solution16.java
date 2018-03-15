package Array;

import sun.security.util.Length;

/**
 * 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class Solution16 {
    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        int[] A = {1, 2, 3, 4, 5};
        int[] B = solution16.multiply(A);
        for (int i = 0; i < B.length; i++) {
            System.out.println(B[i]);
        }
    }


    /**
     * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
     * 从左到右算 B[i]=A[0]*A[1]*...*A[i-1]
     * 从右到左算B[i]*=A[i+1]*...*A[n-1]
     *
     * @param A
     * @return
     */
    public int[] multiply_2(int[] A) {
        int[] B = new int[A.length];
        if (A.length != 0) {
            B[0] = 1;
            for (int i = 1; i < A.length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            int temp = 1;
            for (int j = A.length - 2; j >= 0; j--) {
                temp *= A[j + 1];
                B[j] *= temp;
            }
        }
        return B;
    }

    /**
     * 用双层for循环，当A中索引与B中索引相同时，不做处理，否则乘上A中元素
     *
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if (A.length != 0) {
            for (int i = 0; i < A.length; i++) {
                B[i] = 1;
                for (int j = 0; j < A.length; j++) {
                    if (i != j) {
                        B[i] *= A[j];
                    }
                }
            }
        }
        return B;
    }
}
