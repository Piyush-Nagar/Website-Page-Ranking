package com.piyush.service.strength;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StrengthRatingCalculator {

  private int strength = 8;

  public StrengthRatingCalculator() {
  }

  public Map<String, Integer> getKeyword(List<String> keywords) {
    int temp = strength;
    Map<String, Integer> keywordList = keywords.stream()
        .collect(Collectors.toMap(x -> x, x -> strength--));
    strength = temp;
    return keywordList;
  }
}
