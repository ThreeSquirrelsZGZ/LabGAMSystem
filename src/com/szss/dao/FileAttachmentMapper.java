
package com.szss.dao;

import com.szss.model.FileAttachment;

import java.util.List;

public interface FileAttachmentMapper {

  List<FileAttachment> getFiles(Long userId);


  void saveFile(FileAttachment fileAttachment);

  void updateCount(Long count,Long id);

  FileAttachment getById(Long id);
   void deleteOutEntity(Integer id);
}
