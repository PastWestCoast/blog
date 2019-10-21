package com.shonan.service;

import com.shonan.service.ArchiveService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
package com.shonan.service;
import com.shonan.mapper.ArchiveMapper;
import com.shonan.util.TimeUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchiveServiceImpl implements ArchiveService {

    @Autowired
    ArchiveMapper archiveMapper;
    @Autowired
    BlogService blogService;

    @Override
    public JSONObject findArchiveNameAndArticleNum() {
        List<String> archives = archiveMapper.findArchives();
        JSONArray archivesJsonArray = new JSONArray();
        JSONObject archiveJson;
        TimeUtil timeUtil = new TimeUtil();
        for(String archiveName : archives){
            archiveJson = new JSONObject();
            archiveJson.put("archiveName",archiveName);
            archiveName = timeUtil.timeYearToWhippletree(archiveName);
            archiveJson.put("archiveArticleNum", blogService.countArticleArchiveByArchive(archiveName));
            archivesJsonArray.add(archiveJson);
        }
        JSONObject returnJson = new JSONObject();
        returnJson.put("status",200);
        returnJson.put("result", archivesJsonArray);
        return returnJson;
    }

    @Override
    public void addArchiveName(String archiveName) {
        int archiveNameIsExist = archiveMapper.findArchiveNameByArchiveName(archiveName);
        if(archiveNameIsExist == 0){
            archiveMapper.addArchiveName(archiveName);
        }
    }
}*/
@Service
public class ArchiveServiceImpl implements ArchiveService{
  @Override
  public List<String> findArchiveNameAndArticleNum() {
    return null;
  }

  @Override
  @Transactional
  public int addArchiveName(String archiveName) {

    return 0;
  }
}