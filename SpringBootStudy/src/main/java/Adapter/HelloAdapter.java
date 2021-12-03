package Adapter;

import org.apache.coyote.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloAdapter {
    @RequestMapping("/t")
    public HttpServletResponse teat(HttpServletRequest req, HttpServletResponse rsp){


        return null;
    }
}
