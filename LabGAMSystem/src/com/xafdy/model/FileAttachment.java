
package com.xafdy.model;
public class FileAttachment {

  //id
  private Long id;
  //文件名
  private String name;
  //上传者
  private Long userId;
  //下载次数
  private Long downLoadCount;
  //上传时间
  private String uploadTime;
  //文件大小
  private String size;
  //存储路径
  private String path;

  private String hid;

  public String getHid() {
    return hid;
  }

  public void setHid(String hid) {
    this.hid = hid;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getDownLoadCount() {
    return downLoadCount;
  }

  public void setDownLoadCount(Long downLoadCount) {
    this.downLoadCount = downLoadCount;
  }

  public String getUploadTime() {
    return uploadTime;
  }

  public void setUploadTime(String uploadTime) {
    this.uploadTime = uploadTime;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }
}
