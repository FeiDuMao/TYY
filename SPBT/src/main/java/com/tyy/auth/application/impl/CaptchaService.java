package com.tyy.auth.application.impl;


import com.google.code.kaptcha.Producer;
import com.tyy.auth.adapter.in.view.LoginBody;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CaptchaService {

    Producer producer;

    public void sendCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String text = producer.createText();
        String uuid = UUID.randomUUID().toString();

        response.setDateHeader("Expires", 3*60);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");
        // store the text in the session
        request.getSession().setAttribute(uuid, text);
        // create the image with the text
        BufferedImage bi = producer.createImage(text);

        // write the data out
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            ImageIO.write(bi, "jpg", out);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }

        System.out.println(uuid);
    }


    public boolean validateCaptcha(HttpServletRequest request, LoginBody loginBody) {
        String captcha = (String) request.getSession().getAttribute(loginBody.getUuid());
        request.getSession().removeAttribute(loginBody.getUuid());
        return loginBody.getCaptcha().equals(captcha);
    }


}
