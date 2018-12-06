package com.xafdy.service;

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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.xafdy.dao.MessageMapper;
import com.xafdy.model.Message;

@Service
public class MessageService{
	@Resource
	private MessageMapper messageMapper;
	
	public List<Message> getInMessages( Integer receiverid) {
	    List<Message> Messages = new ArrayList<>();
	    Messages = messageMapper.getInMessages(receiverid);
	    return Messages;
	  }
	public List<Message> getOutMessages( Integer sendid) {
	    List<Message> Messages = new ArrayList<>();
	    Messages = messageMapper.getOutMessages(sendid);
	    return Messages;
	  }
	public void saveMessage(Message message) {
		messageMapper.saveEntity(message);
		
	}
	public void deleteInMessage(Integer id) {
		messageMapper.deleteInEntity(id);
	}
	public void deleteOutMessage(Integer id) {
		messageMapper.deleteOutEntity(id);
	}
	public Message getMessage(Integer id) {
		return messageMapper.getEntityById(id);
	}
	
	public void downloadFile(String filename, HttpServletResponse response,
			HttpServletRequest request) throws UnsupportedEncodingException {
	
	    response.setHeader("content-type", "application/octet-stream");
	    response.setContentType("application/octet-stream");
	    response.addHeader("Content-Disposition",
	        "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
	    byte[] buff = new byte[1024];
	    BufferedInputStream bis = null;
	    OutputStream os;
	    String filePath=request.getServletContext().getRealPath("/files/")+"//"+filename;
	    System.out.println(filePath);
	    try {
	      os = response.getOutputStream();
	      bis = new BufferedInputStream(new FileInputStream(new File(filePath)));
	      int i = bis.read(buff);
	      while (i != -1) {
	        os.write(buff, 0, buff.length);
	        os.flush();
	        i = bis.read(buff);
	      }

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
}
