package com.piyush.service.file;

import com.piyush.model.file.Page;
import com.piyush.util.GenericFileReader;
import java.util.List;
import java.util.function.Function;
import org.springframework.stereotype.Service;

@Service
public class WebPageReader implements Function<String, List<Page>> {

  @Override
  public List<Page> apply(String pageFileName) {
    return GenericFileReader.getAbstractParser(Page.class, pageFileName);
  }
}
