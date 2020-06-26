package com.alfabattle.controller;

import com.alfabattle.api.Message;
import com.alfabattle.api.OutputMessage;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 18:27
 */
@Controller
public class ChatController {

  private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

  @SneakyThrows
  @MessageMapping("/chat")
  @SendTo("/topic/messages")
  public OutputMessage send(@NotNull Message message) {
    var time = DATE_TIME_FORMATTER.format(LocalDateTime.now());
    Thread.sleep(10000);
    return new OutputMessage(message.getFrom(), message.getText(), time);
  }
}
