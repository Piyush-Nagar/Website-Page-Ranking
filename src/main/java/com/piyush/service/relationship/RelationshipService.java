package com.piyush.service.relationship;

import com.piyush.model.file.Page;
import com.piyush.model.file.Query;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public abstract class RelationshipService {
  public List<Entry<String, Map<String, Integer>>> getQueryPageRelationship(List<Page> pages,
                                                                            List<Query> webQueries) {
    return webQueries.stream()
        .map(x -> getRelationshipWithAllPages(x, pages))
        .collect(Collectors.toList());
  }

  public abstract Entry<String, Map<String, Integer>> getRelationshipWithAllPages(Query query,

                                                                                  List<Page> pages);

  public abstract Entry<String, Integer> getRelationshipWithOnePage(Query query,
                                                                    Page page);


}
