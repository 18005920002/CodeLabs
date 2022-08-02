package com.labs.app;

import java.util.Random;

public class Calculate {
    public static void main(String[] args) {
		/*randomAddForm(10);
		System.out.println("\n---");
		randomSubForm(10);
		System.out.println("\n---");
        */
        randomMixForm(200);
    }

    static void randomAddForm(int count) {
        Random r = new Random();
        int a = 0;
        int b = 0;
        for (int i = 0; i < count; i++) {
            a = r.nextInt(10) + 1;
            b = r.nextInt(10) + 1;
            System.out.println(a + " + " + b + " = ");
            //System.out.println(a+":"+b);
			/*while(a==b){
				b = new Random().nextInt(11)+1;
			}
			if(a>b)
				System.out.println(a+" - "+ b +" = ");
			else
				System.out.println(b+" - "+ a +" = ");*/
        }
    }

    static void randomSubForm(int count) {
        int a = 0;
        int b = 0;
        Random r = new Random();
        for (int i = 0; i < count; i++) {
            a = r.nextInt(10) + 1;
            b = r.nextInt(10) + 1;
            //System.out.println(a+":"+b);
            while (a == b) {
                b = r.nextInt(11) + 1;
            }
            if (a > b)
                System.out.println(a + " - " + b + " = ");
            else
                System.out.println(b + " - " + a + " = ");
        }
    }

    static void randomMixForm(int count) {
        int a = 0;
        int b = 0;
        int c = 0;
        int t = 0;
        OP op = OP.add;//0:+  1:-
        Random r = new Random();
        for (int i = 0; i < count; i++) {
            a = r.nextInt(10) + 1;
            b = r.nextInt(10) + 1;
            c = r.nextInt(10) + 1;

            op = r.nextInt(2) % 2 == 0 ? OP.add : OP.sub;
            //先减后加
            if (op == OP.sub) {
                if (a - b >= 0) {
                    System.out.println(a + " - " + b + " + " + c + " = ");
                } else {
                    System.out.println(b + " - " + a + " + " + c + " = ");
                }
            }
            //先加后减
            else {
                if (a + b - c > 0) {
                    System.out.println(a + " + " + b + " - " + c + " = ");
                } else {
                    System.out.println(c + " - " + a + " + " + b + " = ");
                }
            }
        }
    }
}

enum OP {
    add, sub
}
