package com.alfabattle.client;

import com.alfabattle.configuration.AlfaBankFeignConfiguration;
import com.alfabattle.dto.TestRequest;
import com.alfabattle.dto.TestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "AlfaBankClient", url = "${alfabank.api.url}", configuration = AlfaBankFeignConfiguration.class)
public interface AlfaBankFeignClient {

  @RequestMapping(method = RequestMethod.POST, value = "/hello", produces = "application/json")
  TestResponse getRates(@RequestBody TestRequest base);
}
