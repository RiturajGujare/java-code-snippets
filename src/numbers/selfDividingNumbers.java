package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class selfDividingNumbers {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("enter left limit: ");
        int left = sc.nextInt();
        System.out.println("enter right limit: ");
        int right = sc.nextInt();

        List<Integer> selfDividingNumberList = new ArrayList<>();

        for(int num=left; num<=right; num++){
            if(isSelfDividingNumber(num)){
                selfDividingNumberList.add(num);
            }
        }

        System.out.println(selfDividingNumberList);

        sc.close();
    }

    public static boolean isSelfDividingNumber(int num){
        int tempNum = num;
        while(tempNum>0){
            int remainder = tempNum%10;
            
            if(remainder == 0) return false;
            
            if(num%remainder != 0){
                return false;
            }
            tempNum = tempNum/10; 
        }

        return true;
    }
}
