package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class Solution43 {
    ArrayList<Integer> list = new ArrayList<>();
    // 大顶堆
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    // 小顶堆，并且大顶堆元素都大于小顶堆
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // 当前数据流读入的元素个数
    int N = 0;

    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        solution43.Insert_2(3);
        System.out.println(solution43.GetMedian_2());
        solution43.Insert_2(4);
        System.out.println(solution43.GetMedian_2());
    }

    /**
     * 维护两个堆，一个大顶堆、一个小顶堆
     *
     * @param val
     */
    public void Insert_2(Integer num) {
        // 插入要保证两个堆存于平衡状态
        if (N % 2 == 0) {
            // N 为偶数的情况下插入到小顶堆。
            // 因为大顶堆元素都要大于小顶堆，但是新插入的元素不一定比小顶堆元素来的大，
            // 因此需要先将元素插入小顶堆，然后利用小顶堆为大顶堆的特点，取出堆顶元素即为最大元素，此时插入大顶堆
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        N++;
    }

    public Double GetMedian_2() {
        if (N % 2 == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return (double) minHeap.peek();
        }
    }

    /**
     * 维护数组，加入时排序
     *
     * @param num
     */
    public void Insert(Integer num) {
        list.add(num);
        Collections.sort(list);
    }

    public Double GetMedian() {
        int n = list.size();
        if (n % 2 == 0) {
            return Double.valueOf((list.get(n / 2) + list.get(n / 2 - 1)) / 2.0);
        } else {
            return Double.valueOf(list.get(n / 2));
        }
    }
}
