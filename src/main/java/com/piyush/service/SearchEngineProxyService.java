package com.piyush.service;

import com.piyush.model.file.Page;
import com.piyush.model.file.Query;
import com.piyush.service.filter.TopPageFilterService;
import com.piyush.service.file.WebPageReader;
import com.piyush.service.file.WebQueryReader;
import com.piyush.service.relationship.PageQueryRelationshipService;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.stereotype.Service;

@Service
public class SearchEngineProxyService {
  private final WebPageReader webPageReader;
  private final WebQueryReader webQueryReader;
  private final PageQueryRelationshipService relationshipService;
  private final TopPageFilterService topPageFilterService;

  public SearchEngineProxyService(WebPageReader webPageReader,
                                  WebQueryReader webQueryReader,
                                  PageQueryRelationshipService pageQueryRelationshipService,
                                  TopPageFilterService topPageFilterService) {
    this.webPageReader = webPageReader;
    this.webQueryReader = webQueryReader;
    this.relationshipService = pageQueryRelationshipService;
    this.topPageFilterService = topPageFilterService;
  }

  public List<Entry<String, List<String>>> getPagesForEachQuery(String pageFileName,
                                                                String queryFileName) {
    List<Page> pages = webPageReader.apply(pageFileName);
    List<Query> webQueries = webQueryReader.apply(queryFileName);
    List<Entry<String, Map<String, Integer>>> relationshipInfo =
        relationshipService.getQueryPageRelationship(pages, webQueries);
    return topPageFilterService.filterTopFivePages(relationshipInfo);
  }
}
