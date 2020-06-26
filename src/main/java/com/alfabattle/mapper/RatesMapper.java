package com.alfabattle.mapper;

import com.alfabattle.api.Rates;
import com.alfabattle.dto.TestResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 11:45
 */
@Mapper(componentModel = "spring")
public interface RatesMapper {

  @Mapping(source = "requestDate", target = "date")
  Rates map(TestResponse rates);
}
