package com.alfabattle.handler.websocket;

import com.alfabattle.api.Message;
import com.alfabattle.api.OutputMessage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;
import java.util.concurrent.BlockingQueue;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 19:10
 */
@Slf4j
@RequiredArgsConstructor
public class AlfaStompSessionHandlerAdapter extends StompSessionHandlerAdapter {

  private final BlockingQueue<OutputMessage> outputMessage;
  private final Message message;

  @Override
  public void afterConnected(@NotNull StompSession session,
                             @NotNull StompHeaders connectedHeaders) {
    logger.info("New session established : " + session.getSessionId());
    session.subscribe("/topic/messages", this);
    logger.info("Subscribed to /topic/messages");
    session.send("/app/chat", message);
    logger.info("Message sent to websocket server");
  }

  @Override
  public void handleException(@NotNull StompSession session,
                              StompCommand command,
                              @NotNull StompHeaders headers,
                              byte @NotNull [] payload,
                              @NotNull Throwable exception) {
    logger.error("Got an exception", exception);
  }

  @Override
  public @NotNull Type getPayloadType(@NotNull StompHeaders headers) {
    return OutputMessage.class;
  }

  @SneakyThrows
  @Override
  public void handleFrame(@NotNull StompHeaders headers,
                          Object payload) {
    OutputMessage msg = (OutputMessage) payload;
    logger.info("Received : " + msg.getText() + " from : " + msg.getFrom());
    outputMessage.put(msg);
  }
}
