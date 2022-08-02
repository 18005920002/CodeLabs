package com.labs.designpattern.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ������
 *
 * @author win
 */
public class TeaWithHook extends CaffeinBeverageWithHook {

    /**
     * �ݲ��
     */
    public void brew() {
        System.out.println("Steeping the tea");
    }

    /**
     * ������
     */
    public void addCondiments() {
        System.out.println("Adding Lemon");
    }

    @Override
    public boolean customerWantsCondiments() {
        String answer = getUserInput();
        if ((answer.toLowerCase()).startsWith("y")) {
            return true;
        } else {
            return false;
        }
    }


    public String getUserInput() {
        String answer = null;

        System.out.println("Would you like milk and sugar with your coffee (y/n)?");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException ioe) {
            System.err.println("IO error trying to read your answer");
        }

        if (answer == null) {
            return "no";
        }
        return answer;

    }
}
