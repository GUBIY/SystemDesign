package com.example.ratelimiter;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.io.*;

@RestController
public class HandlerController {

  @RequestMapping
  public String handler() throws Exception {
    throw new Exception("test");

  }

  @RequestMapping(value = "/dosomething", method = RequestMethod.GET)
  public void dosomething(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setStatus(429);
    response.getOutputStream().write("Too many requests".getBytes());
  }

}
