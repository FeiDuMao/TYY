package com.tyy.config;

import com.google.code.kaptcha.text.impl.DefaultTextCreator;
import org.junit.Test;

import java.util.Random;

public class CaptchaTextCreator extends DefaultTextCreator {

    @Override
    public String getText() {
        Random random=new Random();
        StringBuilder sb=new StringBuilder("");
        for (int i = 0; i < 4; i++) {
            char ch=(char)('A'+random.nextInt(26));
            sb.append(ch);
        }

        return sb.toString();
    }


    @Test
    public void test(){
        Random random=new Random();
        StringBuilder sb=new StringBuilder("");

        for (int i = 0; i <400 ; i++) {
            char ch=(char)('A'+random.nextInt(26));
            System.out.println(ch);
            // sb.append(ch);
        }
        System.out.println(sb);



    }
}
