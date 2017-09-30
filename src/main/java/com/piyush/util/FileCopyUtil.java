package com.piyush.util;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileCopyUtil {

  public static void makeFileFromUploadedFile(MultipartFile multipartFile) {
    try {
      File file = new File(multipartFile.getOriginalFilename());
      FileUtils.touch(file);
      FileUtils.writeByteArrayToFile(file, multipartFile.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
