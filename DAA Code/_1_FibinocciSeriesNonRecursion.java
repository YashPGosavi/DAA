/*
Time Complexity = O(n)
Space Complexity = O(1)
 */
public class _1_FibinocciSeriesNonRecursion{

    public static void fib(int n){
        int prev=0;
        int next=1;

        for(int i=0;i<n-1;i++){
            int ans = prev + next;
            System.out.print(ans+" ");
            prev = next;
            next = ans;
        }
    }
    public static void main(String[] args) {
        System.out.print(0+" "+1+" ");
        fib(5);
    }
}