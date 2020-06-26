package com.alfabattle.client.websocket;

import com.alfabattle.api.Message;
import com.alfabattle.api.OutputMessage;
import com.alfabattle.handler.websocket.AlfaStompSessionHandlerAdapter;
import com.alfabattle.property.alfabank.WebSocketProperty;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 18:45
 */
@Service
@EnableConfigurationProperties(WebSocketProperty.class)
@RequiredArgsConstructor
public class AlfaWebSocketClientImpl implements AlfaWebSocketClient {

  private final WebSocketProperty webSocketProperty;

  @SneakyThrows
  @Override
  public @NotNull OutputMessage getMessage(@NotNull Message message) {
    WebSocketClient webSocketClient = new StandardWebSocketClient();
    WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
    stompClient.setMessageConverter(new MappingJackson2MessageConverter());

    BlockingQueue<OutputMessage> queue = new SynchronousQueue<>();
    StompSessionHandler sessionHandler = new AlfaStompSessionHandlerAdapter(queue, message);
    stompClient.connect(webSocketProperty.getUrl(), sessionHandler);
    return queue.take();
  }
}
