package com.piyush.util;

import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.csv.CsvFormat;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import java.io.File;
import java.util.List;

public class GenericFileReader {
  private static final String BANK_DATA_FILE = "Page-To-Keyword.csv";
  private static final Character SEPARATOR = '~';

  private GenericFileReader() {
  }

  /**
   * getPagesForEachQuery CsvWriter object for passed model, file path and header.
   * depend on header model and file path it will written the writer.
   *
   * @return {@link com.univocity.parsers.csv.CsvWriter}
   */
  public synchronized static <T> List<T> getAbstractParser(Class<T> tClass, String file) {
    CsvParserSettings settings = new CsvParserSettings();
    settings.setNullValue("");
    settings.setEmptyValue("");
    settings.setHeaderExtractionEnabled(false);
    settings.trimValues(true);
    CsvFormat csvFormat = new CsvFormat();
    csvFormat.setDelimiter(SEPARATOR);
    settings.setFormat(csvFormat);
    BeanListProcessor<T> beanListProcessor = new BeanListProcessor<T>(tClass);
    settings.setProcessor(beanListProcessor);
    CsvParser csvParser = new CsvParser(settings);
    csvParser.parse(new File(file));
    return beanListProcessor.getBeans();
  }
}
