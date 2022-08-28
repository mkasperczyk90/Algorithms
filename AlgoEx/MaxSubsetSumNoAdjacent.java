package AlgoEx;

public class MaxSubsetSumNoAdjacent {
    public static void main(String args[]) {
        MaxSubsetSumNoAdjacent program = new MaxSubsetSumNoAdjacent();

        // params
        int[] array = { 75, 105, 120, 75, 90, 158 };

        // execute
        int result = program.maxSubsetSumNoAdjacent(array);
        int result2 = program.maxSubsetSumNoAdjacent2(array);

        // display
        System.out.println(result);
        System.out.println(result2);
    }

    // time: O(N)
    // space: O(N)
    public int maxSubsetSumNoAdjacent(int[] array) {
        if (array.length == 0)
            return 0;
        else if (array.length == 1)
            return array[0];

        int[] maxSums = array.clone();
        maxSums[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            maxSums[i] = Math.max(maxSums[i - 1], maxSums[i - 2] + array[i]);
        }
        return maxSums[array.length - 1];
    }

    // time: O(N)
    // space: O(1)
    public int maxSubsetSumNoAdjacent2(int[] array) {
        if (array.length == 0)
            return 0;
        else if (array.length == 1)
            return array[0];
        int secound = array[0];
        int first = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            int current = Math.max(first, secound + array[i]);
            secound = first;
            first = current;
        }
        return first;
    }
}
