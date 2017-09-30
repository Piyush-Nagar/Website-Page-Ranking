package com.piyush.service.conversion;

import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import com.piyush.service.strength.StrengthRatingCalculator;
import com.univocity.parsers.conversions.ObjectConversion;
import java.util.List;
import java.util.Map;


public class PageQueryConversion extends ObjectConversion<Map.Entry<String, Map<String, Integer>>> {
  private static final Splitter SPLITTER_ON_TAB = Splitter.on('|');
  private static final Splitter SPLITTER_ON_COMMA = Splitter.on(',');

  public PageQueryConversion(String[] arg) {
  }

  @Override
  protected Map.Entry<String, Map<String, Integer>> fromString(String pageDetail) {
    List<String> pageDetails = SPLITTER_ON_TAB.splitToList(pageDetail);
    String pageName = pageDetails.get(0);
    Map<String, Integer> keywordStrenghtMap = new StrengthRatingCalculator().getKeyword(
        SPLITTER_ON_COMMA.splitToList(
            pageDetails.get(1)));
    return Maps.immutableEntry(pageName, keywordStrenghtMap);
  }
}
