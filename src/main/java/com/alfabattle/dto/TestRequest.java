package com.alfabattle.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * User: @AleksandrMIM
 * Date: 25.06.2020
 * Time: 23:32
 */
@Getter
@Setter
@NoArgsConstructor
public class TestRequest {

  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate localDate = LocalDate.now();
  private String currency;
}
