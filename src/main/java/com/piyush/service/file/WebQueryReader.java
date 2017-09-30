package com.piyush.service.file;

import com.piyush.model.file.Query;
import com.piyush.util.GenericFileReader;
import java.util.List;
import java.util.function.Function;
import org.springframework.stereotype.Service;

@Service
public class WebQueryReader implements Function<String, List<Query>> {

  @Override
  public List<Query> apply(String queryFileName) {
    return GenericFileReader.getAbstractParser(Query.class, queryFileName);
  }
}
