package com.piyush.service.strength;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StrengthRatingCalculator {

  private int strength;

  public Map<String, Integer> getKeyword(List<String> keywords, int strengthLocal) {
    int temp = strength = strengthLocal;
    Map<String, Integer> keywordList = keywords.stream()
        .collect(Collectors.toMap(x -> x, x -> strength--));
    strength = temp;
    return keywordList;
  }
}
