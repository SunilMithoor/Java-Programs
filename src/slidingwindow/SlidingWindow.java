package slidingwindow;

import java.util.*;


/**
 * You're referring to the Sliding Window Maximum problem,
 * where you're given an array and a window size k,
 * and the task is to find the maximum value in each sliding window of size k
 * <p>
 * Input:
 * nums = [1, 3, -1, -3, 5, 3, 6, 7]
 * k = 3
 * <p>
 * Output:
 * [3, 3, 5, 5, 6, 7]
 * <p>
 * Explanation:
 * <p>
 * For each window of size 3:
 * [1, 3, -1] → max = 3
 * [3, -1, -3] → max = 3
 * [-1, -3, 5] → max = 5
 * [-3, 5, 3] → max = 5
 * [5, 3, 6] → max = 6
 * [3, 6, 7] → max = 7
 */


public class SlidingWindow {

    /*
✅ 1. Brute Force Approach (O(n * k))
💡 Idea:

For each window, iterate through the k elements and find the maximum.
 Downside:

Inefficient for large arrays. Time complexity is O(n × k).

✅ Explanation:

    For each window, we scan all k elements to find the maximum.
    Simple to understand but inefficient for large arrays.
 */
    public static int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Loop through the array and compute max in each window of size k
        for (int i = 0; i <= n - k; i++) {
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            result[i] = max;
        }

        return result;
    }


    /*
    2. Using Max Heap / PriorityQueue (O(n log k))
    💡 Idea:

    Use a max-heap (via PriorityQueue with custom comparator) to keep track of the maximum in the current window.

    ✅ Pros:
        Cleaner than brute force.
        Works well if the array is not huge.
    ❌ Cons:
        Slower than Deque method due to heap operations (O(log k) per element).

        ✅ Explanation:

        A max heap keeps the largest element on top.
        We keep track of both the value and the index, and remove any elements from the heap that are outside the current window.
        Slower than the deque method due to O(log k) heap operations.
     */
    static class Pair {
        int value;
        int index;

        Pair(int v, int i) {
            value = v;
            index = i;
        }
    }

    public static int[] maxSlidingWindowHeap(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Max heap using a comparator (higher value first)
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.value - a.value);

        for (int i = 0; i < n; i++) {
            maxHeap.offer(new Pair(nums[i], i));

            // Remove elements outside the current window
            while (maxHeap.peek().index <= i - k) {
                maxHeap.poll();
            }

            // Add max to result once we have the first full window
            if (i >= k - 1) {
                result[i - k + 1] = maxHeap.peek().value;
            }
        }

        return result;
    }



    /*
    How It Works:
        Uses a Deque to store indices of useful elements in current window.
        Removes elements from the front if they're outside the window.
        Maintains the deque in decreasing order of values.
        The front of the deque always holds the index of the maximum value in the current window.

        ✅ Explanation:

        We use a deque to store indices of useful elements for the current window.
        We remove elements from the back if they're smaller than the current element
         (nums[i]), because they will never be the max.
        The front of the deque always holds the index of the largest value for the current window.
     */
    public static int[] maxSlidingWindowDeque(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove indices whose corresponding values are less than nums[i]
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Add max to result starting from i = k - 1
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("\n-----Start-----\n");
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result1 = maxSlidingWindowBruteForce(nums, k);
        System.out.println("Brute force method: " + Arrays.toString(result1)); // [3, 3, 5, 5, 6, 7]

        int[] result2 = maxSlidingWindowHeap(nums, k);
        System.out.println("Heap method: " + Arrays.toString(result2)); // [3, 3, 5, 5, 6, 7]

        int[] result3 = maxSlidingWindowDeque(nums, k);
        System.out.println("Deque method: " +Arrays.toString(result3)); // Output: [3, 3, 5, 5, 6, 7]

        System.out.println("\n-----End-----\n");
    }
}

/*

🔚 Summary:
Method	Time Complexity	Space Complexity	Description
Deque	O(n)	O(k)	Best performance, most efficient
Heap	O(n log k)	O(k)	Easy to write, less efficient
Brute Force	O(n × k)	O(1)	Simple but slow for big inputs
 */