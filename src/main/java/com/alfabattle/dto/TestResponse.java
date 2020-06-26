package com.alfabattle.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 11:45
 */
@Getter
@Setter
public class TestResponse {

  private String base;
  private String requestDate;
  private Map<String, Double> rates;
}
