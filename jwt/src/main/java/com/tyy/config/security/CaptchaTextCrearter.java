package com.tyy.config.security;

import com.google.code.kaptcha.text.impl.DefaultTextCreator;
import org.junit.Test;

import java.util.Random;


public class CaptchaTextCrearter extends DefaultTextCreator {

    @Override
    public String getText() {
        Random random=new Random();
        int a = random.nextInt(10);
        int b = random.nextInt(10);
        int c = random.nextInt(3);

        StringBuilder s=new StringBuilder();

        int ans=0;
        if (c==0){
            ans=a+b;
            s.append(a);
            s.append("+");
            s.append(b);
        }else if (c==1){
            ans=a-b;
            if (ans<0){
                ans=b-a;
                s.append(b);
                s.append("-");
                s.append(a);
            }else{
                s.append(a);
                s.append("-");
                s.append(b);
            }

        }else if (c==2){
            ans=a*b;
            s.append(a);
            s.append("*");
            s.append(b);
        }
        s.append("=?@");
        s.append(ans);

        return s.toString();
    }


    @Test
    public void test(){

        StringBuilder s=new StringBuilder();
        s.append(12345);

        System.out.println(s);
        s.replace(2,4,"t");
        System.out.println(s);




    }
}
