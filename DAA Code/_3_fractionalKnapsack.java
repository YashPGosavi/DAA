/*
Fractional Knapsack
Given the weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
value = [60, 100, 120]
weight = [10, 20, 30]
W = 50

finalval = 240

 */

import java.util.*;

public class _3_fractionalKnapsack {

    public static void fractionalKnapsack(int[] value, int[] weight, int W) {
        
        double [][] arr = new double [value.length][2];
        int finalval = 0;
        int capacity = W;
        

        for(int i=0;i<value.length;i++){
            arr[i][0] = i;
            arr[i][1] = value[i]/(double)weight[i];
        }

        Arrays.sort(arr,Comparator.comparingDouble(o->o[1]));

        for(int i=value.length-1;i>=0;i--){
            int j =(int) arr[i][0];

            if(capacity >= weight[j]){
                finalval += value[j];
               capacity -= weight[j];
            }else{
               finalval += (arr[i][1] * capacity);
               capacity = 0;
               break;
            }
        }

        System.out.println(finalval);

    }

    public static void main(String[] args) {
        int[] value = { 60, 100, 120 };
        int[] weight = { 10, 20, 30 };
        int W = 50;

        fractionalKnapsack(value, weight, W);
    }
}