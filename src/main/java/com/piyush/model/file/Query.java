package com.piyush.model.file;

import com.piyush.service.conversion.PageQueryConversion;
import com.univocity.parsers.annotations.Convert;
import com.univocity.parsers.annotations.Parsed;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Query {
  @Convert(conversionClass = PageQueryConversion.class)
  @Parsed(index = 0)
  Map.Entry<String, Map<String, Integer>> queryNameToKeyWordMap;
}
