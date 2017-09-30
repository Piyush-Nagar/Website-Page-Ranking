package com.piyush.controller;

import com.piyush.service.SearchEngineProxyService;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RelationshipController {

  private final SearchEngineProxyService searchEngineProxyService;

  public RelationshipController(SearchEngineProxyService searchEngineProxyService) {
    this.searchEngineProxyService = searchEngineProxyService;
  }

  /**
   * find the page ranking for a Query.
   * @param pageFileName pageFile name uploaded by use.
   * @param queryFileName queryFileName uploaded by user.
   * @return return rank of each page for each query.
   */
  @ResponseBody
  @GetMapping(value = "/page-ranking")
  public ResponseEntity<?> getPageRanking(@RequestParam("pageFileName") String pageFileName,
                                          @RequestParam("queryFileName") String queryFileName) {
    List<Map.Entry<String, List<String>>> pagesForEachQuery =
        searchEngineProxyService.getPagesForEachQuery(pageFileName, queryFileName);
    return ResponseEntity.ok(pagesForEachQuery);
  }
}
