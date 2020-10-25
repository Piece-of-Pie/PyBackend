package com.pieceofpie.py.config;

import com.google.common.collect.Maps;
import com.pieceofpie.py.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;

import java.util.Map;

public class Integer2EnumConverter<T extends BaseEnum> implements Converter<Integer, T> {
  private Map<Integer, T> enumMap = Maps.newHashMap();

  public Integer2EnumConverter(Class<T> enumType) {
    T[] enums = enumType.getEnumConstants();
    for (T e : enums) {
      enumMap.put(e.getCode(), e);
    }
  }
  @Override
  public T convert(Integer source) {
    if (!enumMap.containsKey(source)) {
      throw new IllegalArgumentException("无法匹配对应的枚举类型");
    }
    return enumMap.get(source);
  }
}
