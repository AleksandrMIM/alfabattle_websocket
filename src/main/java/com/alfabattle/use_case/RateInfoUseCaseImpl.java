package com.alfabattle.use_case;

import com.alfabattle.api.Message;
import com.alfabattle.api.Rates;
import com.alfabattle.client.AlfaBankFeignClient;
import com.alfabattle.client.websocket.AlfaWebSocketClient;
import com.alfabattle.dto.TestRequest;
import com.alfabattle.mapper.RatesMapper;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 12:19
 */
@Service
@RequiredArgsConstructor
public class RateInfoUseCaseImpl implements RateInfoUseCase {

  private final AlfaBankFeignClient alfaBankFeignClient;
  private final RatesMapper ratesMapper;
  private final AlfaWebSocketClient alfaWebSocketClient;

  @Override
  public @NotNull Rates getRate(@NotNull String currency) {
    var response = alfaBankFeignClient.getRates(new TestRequest());
//    var webSocketResponse = alfaWebSocketClient.getMessage(getSampleMessage());
//    response.setBase(webSocketResponse.getFrom());

    return ratesMapper.map(response);
  }

//  private @NotNull Message getSampleMessage() {
//    Message msg = new Message();
//    msg.setFrom("Nicky");
//    msg.setText("Howdy!!");
//    return msg;
//  }
}
