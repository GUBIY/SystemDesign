package com.example.ratelimiter;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.io.*;

@RestController
public class HandlerController {
  //////////////////////////////////
  // Testing Apache Bench
  // ab -n 100 -c 100 http://localhost:8090/monolithicdosth
  //////////////////////////////////
  public static final String ERR_TOO_MANY_REQUESTS = "Too many requests";
  public static final String LOG_EXCEED_REQUEST_LIMIT = "Reaching the limit of the request:{%d}";
  public static int processingReqCount = 0;
  public static int processingReqLimit = 10;
  public static final Object syncObj = new Object();

  public String handler() throws Exception {
    throw new Exception("test");
  }


  @RequestMapping(value = "/monolithicdosth", method = RequestMethod.GET)
  public void dosomething(HttpServletRequest request, HttpServletResponse response) throws IOException {
    synchronized (syncObj) {
      processingReqCount++;
      try {
        if (processingReqCount >= processingReqLimit) {
          System.out.println(String.format(LOG_EXCEED_REQUEST_LIMIT, processingReqCount));
          response.setStatus(429);
          response.getOutputStream().write(ERR_TOO_MANY_REQUESTS.getBytes());
          return;
        }
        // TODO:想想我们怎么搞一下，这个处理request的逻辑
        processRequest();
      } finally {
        processingReqLimit--;
      }
    }
  }

  private void processRequest() {

  }
}
