package com.alfabattle.configuration;

import com.alfabattle.property.alfabank.AlfaBankApiProperty;
import feign.Client;
import lombok.RequiredArgsConstructor;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 13:41
 */
@Configuration
@EnableConfigurationProperties(AlfaBankApiProperty.class)
@RequiredArgsConstructor
public class AlfaBankFeignConfiguration {

  private final AlfaBankApiProperty alfaBankApiProperty;

  @Bean
  public Client getClient() throws IOException, UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
    var keyStore = alfaBankApiProperty.getKeyStore();
    var trustStore = alfaBankApiProperty.getTrustStore();

    return new Client.Default(SSLContextBuilder.create()
        .loadKeyMaterial(new URL(keyStore.getPath()), keyStore.getPassword(), keyStore.getKeyPassword())
        .loadTrustMaterial(new URL(trustStore.getPath()), trustStore.getPassword())
        .build()
        .getSocketFactory(),
        null
    );
  }
}
