package com.alfabattle.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class Rates {

  private String base;
  private String date;
  private Map<String, Double> rates;

  public Rates(String date) {
    this.date = date;
  }
}