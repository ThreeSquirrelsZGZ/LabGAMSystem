/**
 * BBD Service Inc All Rights Reserved @2018
 */

package com.xafdy.dao;

import com.xafdy.model.FileAttachment;

import java.util.List;

/**
 * @author hebiao
 * @version $Id:FileAttachmentMapper.java, v0.1 2018/5/19 11:11 hebiao Exp $$
 */
public interface FileAttachmentMapper {

  List<FileAttachment> getFiles(Long userId);


  void saveFile(FileAttachment fileAttachment);

  void updateCount(Long count,Long id);

  FileAttachment getById(Long id);
   void deleteOutEntity(Integer id);
}
