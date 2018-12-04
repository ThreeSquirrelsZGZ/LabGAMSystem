package com.xafdy.web;

import com.xafdy.model.FileAttachment;
import com.xafdy.service.FileService;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/file")
public class FileController {

  @Resource
  private FileService fileService;

  /**
   * 文件列表
   */
  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView fileList() {
    ModelAndView mav = new ModelAndView();
    Long userId = null;
    mav.addObject("fileList", fileService.getFileList(userId));
    mav.setViewName("fileAttachment");
    return mav;
  }

  @RequestMapping(value = "uploadFile.html", method = RequestMethod.GET)
  public ModelAndView upload() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("uploadFile");
    return mav;
  }


  /**
   * 上传文件
   */
  @RequestMapping(value = "/upload.html", method = RequestMethod.POST)
  //@ResponseBody
  public ModelAndView uploadFile(@RequestParam MultipartFile file, HttpServletRequest request) throws IOException {
    FileAttachment fileAttachment = new FileAttachment();
    String path = request.getServletContext().getRealPath("/files/");
    String name = file.getOriginalFilename();
    File filePath = new File(path, name);
    if (!filePath.getParentFile().exists()) {
      filePath.getParentFile().mkdirs();
    }
    file.transferTo(new File(path + File.separator + name));//将文件上传到files目录
    fileAttachment.setName(name);
    fileAttachment.setPath(path + File.separator + name);
    fileAttachment.setSize(String.valueOf(file.getSize()));
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    fileAttachment.setUploadTime(dateFormat.format(new Date()));
    fileAttachment.setDownLoadCount(0L);
    fileAttachment.setUserId(1L);
    fileAttachment.setSize(String.valueOf(file.getSize()));
    fileService.uploadFile(fileAttachment);

    //return "{\"success\" :\"1\"}";
    
    return new ModelAndView("redirect:/file.html");

  }

  /**
   * 下载文件 方式一
   */
 
  @RequestMapping(value = "downloadFile/{id}", method = RequestMethod.GET)
  public void downloadFile(HttpServletResponse response, @PathVariable("id") Long id)
      throws UnsupportedEncodingException {
	 
    fileService.downloadFile(id, response);
    //return new ModelAndView("redirect:/file.html");
  }
  
  @RequestMapping(value = "deleteFile.html", method = RequestMethod.GET)
  public ModelAndView deleteFile( @RequestParam("id") Integer id)
      throws UnsupportedEncodingException {
	  fileService.deleteFile(id);
	  return new ModelAndView("redirect:/file.html");

  }


}
