package codingninjas.linkedlist.altrimatrix;

import java.util.HashMap;
import java.util.Map;

public class HackerRankAssignment {



    public static  int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int t : time) {
            int d = (60 - t % 60) % 60;
            if (count.containsKey(d)) {
                ans += count.get(d);
            } // in current HashMap, get the number of songs that if adding t equals to a multiple of 60.
            count.put(t % 60, 1 + count.getOrDefault(t % 60, 0)); // update the number of t % 60.
        }
        return ans;
    }


    public static void main(String[] args) {

        System.out.println(numPairsDivisibleBy60(new int[]{60,60,60}));
    }
}
