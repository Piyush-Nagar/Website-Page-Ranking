package com.piyush.controller;

import static com.piyush.enums.RedirectFileAttribute.PAGE_FILE_NAME;
import static com.piyush.enums.RedirectFileAttribute.QUERY_FIE_NAME;

import com.piyush.model.upload.UploadingFiles;
import com.piyush.util.FileCopyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileUploadController {

  /**
   * uploads the file on server.
   * And redirect to controller which gives page ranking.
   *
   * @param uploadingFiles {@link UploadingFiles} to hold the file uploaded for page and query.
   * @param reAttr         {@link RedirectAttributes}
   * @return redirect to uri "/page-ranking" in {@link RelationshipController}.
   */
  @PostMapping(value = "/upload-file")
  public String getPageRankingForQuery(
      @ModelAttribute("uploadingFiles") UploadingFiles uploadingFiles,
      RedirectAttributes reAttr) {

    //get the uploaded file
    MultipartFile pageFile = uploadingFiles.getPageFile();
    MultipartFile queryFile = uploadingFiles.getQueryFile();

    //upload file on server.
    FileCopyUtil.makeFileFromUploadedFile(pageFile);
    FileCopyUtil.makeFileFromUploadedFile(queryFile);

    //send the uploaded file name to redirect controller.
    reAttr.addAttribute(PAGE_FILE_NAME.getAttribute(), pageFile.getOriginalFilename());
    reAttr.addAttribute(QUERY_FIE_NAME.getAttribute(), queryFile.getOriginalFilename());

    //redirect to pageranking controller.
    return "redirect:/page-ranking";
  }

  @GetMapping(value = "/")
  public String searchYouPage() {
    return "upload-file";
  }
}
