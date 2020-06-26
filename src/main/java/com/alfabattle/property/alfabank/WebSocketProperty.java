package com.alfabattle.property.alfabank;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 18:47
 */
@Getter
@Setter
@ConfigurationProperties("websocket.api")
public class WebSocketProperty {

  private String url;
}
