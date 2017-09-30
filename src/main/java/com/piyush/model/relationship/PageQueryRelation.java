package com.piyush.model.relationship;

import com.piyush.model.file.Page;
import com.piyush.model.file.Query;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class PageQueryRelation {
  Map<Query, List<Page>> relationship;
}
