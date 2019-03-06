package com.labs.test.basis.util;

/**
 * Description
 *
 * @author tanyun.zheng
 * @version v1.0 2019/2/26 17:00
 */
public class ForBreak {
    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            System.out.println("i=="+i);
            for(int j=0;j<100;j++){
                System.out.println("j=="+j);
                if(j==20){
                    break;
                }
                System.out.println("to next j");

            }
            System.out.println("::::break from j loop");
            System.out.println("**** to next i");
        }

        System.out.println("====BREAK FROM J LOOP");
    }
}
