package com.alfabattle.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 18:28
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OutputMessage {

  private String from;
  private String text;
  private String time;
}
