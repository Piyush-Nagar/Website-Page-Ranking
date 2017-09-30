package com.piyush.service.relationship;

import static com.google.common.collect.Sets.intersection;

import com.google.common.collect.Maps;
import com.piyush.model.file.Page;
import com.piyush.model.file.Query;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class PageQueryRelationshipService extends RelationshipService {

  @Override
  public Entry<String, Map<String, Integer>> getRelationshipWithAllPages(Query query,
                                                                         List<Page> pages) {

    Map<String, Integer> collect1 = pages.stream()
        .map(webPage -> getRelationshipWithOnePage(query, webPage))
        .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    return Maps.immutableEntry(query.getQueryNameToKeyWordMap().getKey(), collect1);
  }

  @Override
  public Entry<String, Integer> getRelationshipWithOnePage(Query query, Page page) {
    //name, keyword and weight for page and query
    Entry<String, Map<String, Integer>> keywordsWeightForPage = page.getPageNameToKeyWordMap();
    Entry<String, Map<String, Integer>> keywordsWeightForQuery = query.getQueryNameToKeyWordMap();

    //only keywords and weight for page and query.
    Map<String, Integer> keywordsWeight = keywordsWeightForQuery.getValue();
    Map<String, Integer> webpageKeywordWeight = keywordsWeightForPage.getValue();

    //find the strength
    int strengthOfKeyWord = intersection(webpageKeywordWeight.keySet(), keywordsWeight.keySet())
        .stream()
        .mapToInt(common -> keywordsWeight.get(common) * webpageKeywordWeight.get(common))
        .sum();
    return Maps.immutableEntry(keywordsWeightForPage.getKey(), strengthOfKeyWord);
  }
}
