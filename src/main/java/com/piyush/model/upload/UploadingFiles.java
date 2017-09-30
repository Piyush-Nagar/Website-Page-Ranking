package com.piyush.model.upload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UploadingFiles {
  private MultipartFile pageFile;
  private MultipartFile queryFile;

}
