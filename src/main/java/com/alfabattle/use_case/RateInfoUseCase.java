package com.alfabattle.use_case;

import com.alfabattle.api.Rates;

import javax.validation.constraints.NotNull;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 12:18
 */
public interface RateInfoUseCase {

  @NotNull
  Rates getRate(@NotNull String currency);
}
