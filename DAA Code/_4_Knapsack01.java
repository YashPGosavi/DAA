/*
0/1 Knapsack:

0/1 Knapsack is a problem where items cannot be divided, and you can either include an item in the knapsack or exclude it.

        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;

 */

public class _4_Knapsack01 {
    public static int knapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;
        int[][] result = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {

            for (int w = 1; w <= capacity; w++) {

                if (weights[i - 1] > w) {

                    result[i][w] = result[i - 1][w];

                } else {

                    result[i][w] = Math.max(result[i - 1][w], result[i - 1][w - weights[i - 1]] + values[i - 1]);

                }
            }
        }

        return result[n][capacity];
    }

    public static void main(String[] args) {
        int[] values = { 60, 100, 120 };
        int[] weights = { 10, 20, 30 };
        int capacity = 50;

        int maxValue = knapsack(values, weights, capacity);
        System.out.println(maxValue);
    }
}

/*
 * Difference between Fractional Knapsack and 0/1 Knapsack:
 * 
 * 1. Nature of Items:
 * Fractional Knapsack allows items to be divided into fractions, making it
 * suitable for situations where items can be taken in parts.
 * 0/1 Knapsack requires items to be taken as a whole, and you either include an
 * item entirely or exclude it.
 * 
 * 2. Problem Formulation:
 * In Fractional Knapsack, the goal is to maximize the total value while staying
 * within the weight capacity, and it can include a fraction of an item.
 * In 0/1 Knapsack, the goal is to maximize the total value while staying within
 * the weight capacity, and it can't include fractions of items.
 * 
 * 3. Algorithms:
 * Fractional Knapsack can be solved using a greedy algorithm, as shown in the
 * code above.
 * 0/1 Knapsack is typically solved using dynamic programming, as shown in the
 * code above.
 * 
 * 4. Complexity:
 * Fractional Knapsack has a simpler and more efficient solution due to its
 * greedy nature.
 * 0/1 Knapsack is generally more complex and has a higher time complexity due
 * to dynamic programming.
 */