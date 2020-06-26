package com.alfabattle.controller;

import com.alfabattle.api.Rates;
import com.alfabattle.use_case.RateInfoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

  private final RateInfoUseCase rateInfoUseCase;

  @GetMapping("/hello")
  public Rates helloGet(@RequestParam(value = "currency", required = false) String currency) {
    return rateInfoUseCase.getRate(currency);
  }
}
