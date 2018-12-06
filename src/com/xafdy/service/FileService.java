
package com.xafdy.service;

import com.xafdy.dao.FileAttachmentMapper;
import com.xafdy.model.FileAttachment;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class FileService{

  @Resource
  private FileAttachmentMapper fileAttachmentMapper;
  
  //private Father fa=new myFile();
  /**
   * 上传文件
   */
  public void uploadFile(FileAttachment fileAttachment) {
//	System.out.println("myFile");
	  fileAttachmentMapper.saveFile(fileAttachment);
  }

  /**
   * 下载文件
   */
  public void downloadFile(Long fileId, HttpServletResponse response) throws UnsupportedEncodingException {
    Assert.notNull(fileId, "file is null");
    FileAttachment fileAttachment = fileAttachmentMapper.getById(fileId);
    Assert.notNull(fileAttachment, "文件已经被删除");
    response.setHeader("content-type", "application/octet-stream");
    response.setContentType("application/octet-stream");
    response.addHeader("Content-Disposition",
        "attachment; filename=" + URLEncoder.encode(fileAttachment.getName(), "UTF-8"));
    byte[] buff = new byte[1024];
    BufferedInputStream bis = null;
    OutputStream os;
    try {
      os = response.getOutputStream();
      bis = new BufferedInputStream(new FileInputStream(new File(fileAttachment.getPath())));
      int i = bis.read(buff);
      while (i != -1) {
        os.write(buff, 0, buff.length);
        os.flush();
        i = bis.read(buff);
      }
      
      fileAttachmentMapper.updateCount(fileAttachment.getDownLoadCount()+1,fileId);

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (bis != null) {
        try {
          bis.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }


  }

  /**
   * 获取文件列表
   */
  public List<FileAttachment> getFileList(Long userId) {
    List<FileAttachment> fileAttachments = new ArrayList<>();
    fileAttachments = fileAttachmentMapper.getFiles(null);
    for(FileAttachment fileAttachment:fileAttachments){
      fileAttachment.setHid(fileAttachment.getId()+".html");
    }
    return fileAttachments;
  }

public void deleteFile(Integer id) {
	fileAttachmentMapper.deleteOutEntity(id);
	
}



}
