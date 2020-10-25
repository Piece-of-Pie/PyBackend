package com.pieceofpie.py.config;

import com.google.common.collect.Maps;
import com.pieceofpie.py.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import java.util.Map;

public class IntegerCode2EnumConverterFactory implements ConverterFactory<Integer, BaseEnum> {
  private static final Map<Class, Converter> CONVERTERS = Maps.newHashMap();
  @Override
  public <T extends BaseEnum> Converter<Integer, T> getConverter(Class<T> targetType) {
    Converter<Integer, T> converter = CONVERTERS.get(targetType);
    if (converter == null) {
      converter = new Integer2EnumConverter<>(targetType);
      CONVERTERS.put(targetType, converter);
    }
    return converter;
  }
}
