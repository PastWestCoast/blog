package com.shonan.service;

import java.util.List;

public interface ArchiveService {
  /*
   * 获得归档信息
   */
  List<String> findArchiveNameAndArticleNum();

  /**
   * 添加归档日期
   */
  int addArchiveName(String archiveName);
}
