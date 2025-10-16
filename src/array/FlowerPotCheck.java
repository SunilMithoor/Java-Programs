package array;


//Flower Pot Adjacent Check (Array-Based) You are given an array of integers representing flower pots.
//A 0 means the pot is empty, and a 1 means the pot has a flower. You need to check if you can plant n
//        new flowers in the pots without violating the rule that no two flowers can be adjacent.


import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class FlowerPotCheck {

    static void main() {

        int[] pots = {1, 0, 0, 0, 1};
        int n = 1;

//        int[] pots = {1, 0, 0, 0, 1};
//        int n = 2;

//        int[] pots = {0, 0, 1, 0, 0};
//        int n = 2;

        System.out.println(canPlantFlowers(pots, n));
        System.out.println(canPlantFlowersStream(pots, n));

    }

    static boolean canPlantFlowers(int[] pots, int n) {
        int count = 0;
        int length = pots.length;

        for (int i = 0; i < length; i++) {
            if (pots[i] == 0) {

                // Check if left and right neighbors are empty (or out of bounds)
                boolean emptyLeft = (i == 0) || (pots[i - 1] == 0);
                boolean emptyRight = (i == length - 1) || (pots[i + 1] == 0);

                if (emptyLeft && emptyRight) {
                    pots[i] = 1;// plant a flower
                    count++;
                }
            }
        }
        return count >= n;
    }


    static boolean canPlantFlowersStream(int[] pots, int n) {
        AtomicInteger count = new AtomicInteger();

        IntStream.range(0, pots.length).forEach(i ->
                {
                    boolean emptyLeft = (i == 0) || (pots[i - 1] == 0);
                    boolean emptyRight = (i == pots.length - 1) || (pots[i + 1] == 0);
                    if (emptyLeft && emptyRight) {
                        pots[i] = 1;
                        count.getAndIncrement();
                    }
                }
        );
        return count.get() >= n;
    }
}

//💡 Explanation
//
//Iterate through the array.
//If the current pot is empty (0), check its neighbors:
//emptyLeft = true if it’s the first pot or the previous pot is empty.
//emptyRight = true if it’s the last pot or the next pot is empty.
//If both are empty, plant a flower (pots[i] = 1) and increment count.
//At the end, check if count >= n.

