package com.piyush.service.filter;

import com.google.common.collect.Maps;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TopPageFilterService {

  public List<Map.Entry<String, List<String>>> filterTopFivePages(List<Map.Entry<String, Map<String, Integer>>> relationshipInfo) {
    return relationshipInfo.stream()
        .map(x -> Maps.immutableEntry(x.getKey(), filterTopFivePages(x.getValue())))
        .collect(Collectors.toList());
  }

  private List<String> filterTopFivePages(Map<String, Integer> x) {
    return x.entrySet()
        .stream()
        .sorted((x1, y1) -> x1.getValue() < y1.getValue() ? 1 : -1)
        .limit(5)
        .map(Map.Entry::getKey)
        .collect(Collectors.toCollection(LinkedList::new));
  }

}
