package com.piyush.enums;

/**
 * when user uploads the file it can be used to hold the file names.
 * And can be used among the controllers.
 */
public enum RedirectFileAttribute {

  PAGE_FILE_NAME("pageFileName"),
  QUERY_FIE_NAME("queryFileName");

  private final String fileNameAttribute;

  RedirectFileAttribute(String fileNameAttribute) {
    this.fileNameAttribute = fileNameAttribute;
  }

  public String getAttribute() {
    return fileNameAttribute;
  }
}
