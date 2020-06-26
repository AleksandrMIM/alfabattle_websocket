package com.alfabattle.property.alfabank;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 13:23
 */
@Getter
@Setter
@ConfigurationProperties("alfabank")
public class AlfaBankApiProperty {

  private KeyStoreInfo trustStore = new KeyStoreInfo();
  private KeyStoreInfo keyStore = new KeyStoreInfo();

  @Getter
  @Setter
  public static class KeyStoreInfo {

    private String path;
    private char[] password;
    private char[] keyPassword;
  }
}
