package com.piyush.model.file;

import com.piyush.service.conversion.PageQueryConversion;
import com.univocity.parsers.annotations.Convert;
import com.univocity.parsers.annotations.Parsed;
import java.util.Map;
import lombok.Data;

@Data
public class Page {
  @Convert(conversionClass = PageQueryConversion.class)
  @Parsed(index = 0)
  Map.Entry<String, Map<String, Integer>> pageNameToKeyWordMap;
}
