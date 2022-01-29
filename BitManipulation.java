import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//import static com.sun.xml.internal.fastinfoset.algorithm.IntegerEncodingAlgorithm.INT_SIZE;

public class BitManipulation {
    public static int findMinXORForGivenIntegers(ArrayList<Integer> A){
        Collections.sort(A);
        int minVal=Integer.MAX_VALUE;
        for(int i=0;i<A.size()-1;i++){
            int xor=A.get(i)^A.get(i+1);
            minVal=Math.min(xor,minVal);
        }
    return minVal;
    }
    public static int numOfSetBits(long a){
        int count=0;
        while(a>0){
            count+=a%2;
            a=a>>1;
        }
        return count;
    }
    public static long reverseBits(long A){
        long rev = 0;

        for (int i = 0; i < 32; i++) {
            rev <<= 1;
            if ((A & (1 << i)) != 0)
                rev |= 1;
        }
        return rev;
    }
    public static int divideIntegers(int dividend, int divisor){
        int sign=((dividend<0)^(divisor<0))?-1:1;
        dividend=Math.abs(dividend);
        divisor=Math.abs(divisor);
        int quotient=0;
        while(dividend>=divisor){
            dividend-=divisor;
            ++quotient;
        }
        return sign*quotient;
    }

    public static int sumOfPairWiseBits(int arr[],int n){
        int ans = 0; // Initialize result

        // traverse over all bits
        for (int i = 0; i < 32; i++) {

            // count number of elements
            // with i'th bit set
            int count = 0;

            for (int j = 0; j < n; j++)
                if ((arr[j] & (1 << i)) == 0)
                    count++;

            // Add "count * (n - count) * 2"
            // to the answer
            ans += (count * (n - count) * 2);
        }

        return ans;
    }
    public static int singleNumber(List<Integer> A){
        long x_sumor=0;
        for(int ai:A){
            x_sumor=x_sumor^ai;
        }
        return (int)x_sumor;
    }
    public static int getSingleII(List<Integer> A, int n){
        int result=0;
        int x, sum;
        for(int i=0;i<10;i++){
            //for(int i=0;i<INT_SIZE;i++){
            sum=0;
            x=(1<<i);
            for(int j=0;j<n;j++){
                if((A.get(j)&x)==0){
                    sum++;
                }
            }
            if(sum%3==0){
                result|=x;
            }

        }
        return result;
    }

    public static void main(String[] args){
        ArrayList<Integer> list=new ArrayList<>(4);
        list.add(0);list.add(4);list.add(7);list.add(9);
        int arr[] = { 1, 3, 5 };
        List<Integer> list1=new ArrayList<>(5);
        list1.add(1);list1.add(2);list1.add(2);list1.add(3);list1.add(1);
        List<Integer> list2=new ArrayList<>(4);
        list2.add(5);list2.add(5);list2.add(5);list2.add(8);
        System.out.println("MinXORForGivenListOFIntegers"+findMinXORForGivenIntegers(list));
        System.out.println("Number Of Set bits"+numOfSetBits(11));
        System.out.println("Reverse bits"+reverseBits(3));
        System.out.println("Divide Two integers"+divideIntegers(10,3));
        System.out.println("Divide Two integers"+divideIntegers(43,-8));
        System.out.println("Sum of PAirWise Bits"+sumOfPairWiseBits(arr,3));
        System.out.println("singleNumber"+singleNumber(list1));
        System.out.println("singleNumber2"+getSingleII(list2,4));
    }
}
