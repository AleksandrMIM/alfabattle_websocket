package com.alfabattle.client.websocket;

import com.alfabattle.api.Message;
import com.alfabattle.api.OutputMessage;
import org.jetbrains.annotations.NotNull;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 18:43
 */
public interface AlfaWebSocketClient {

  @NotNull
  OutputMessage getMessage(@NotNull Message message);
}
