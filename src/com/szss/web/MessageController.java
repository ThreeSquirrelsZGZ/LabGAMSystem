package com.szss.web;
import com.szss.model.Message;
import com.szss.model.People;
import com.szss.model.User;
import com.szss.service.IndexService;
import com.szss.service.MessageService;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/message")
public class MessageController {
	@Resource
	private MessageService messageService;
	@Resource
	private IndexService indexService;
//	@Resource
//	private services1 service;
	
	@RequestMapping(value = "/inbox.html")
	  public ModelAndView inbox(HttpSession session) {
		//service=new MessageService();
		ModelAndView mav = new ModelAndView();
		People user=(People) session.getAttribute("user");
		Integer receiverid=user.getId();
	    //mav.addObject("messageList", messageService.getInMessages(receiverid));
		mav.addObject("messageList", messageService.getInMessages(receiverid));
	    mav.setViewName("inbox");
	    return mav;
	  }
	@RequestMapping(value = "outbox.html", method = RequestMethod.GET)
	  public ModelAndView outbox(HttpSession session) {
		//service=new MessageService();
	    ModelAndView mav = new ModelAndView();
	    People user=(People) session.getAttribute("user");
		Integer sendid=user.getId();
	    mav.addObject("messageList", messageService.getOutMessages(sendid));
	    mav.setViewName("outbox");
	    return mav;
	  }
	@RequestMapping(value = "sendmessage.html", method = RequestMethod.GET)
	  public ModelAndView sendmessage(HttpSession session) {
		//service=new IndexService();
		ModelAndView mav = new ModelAndView();
		People user= (People) session.getAttribute("user");
		Integer userid=user.getId();
		mav.addObject("users", indexService.getMessageUsers(userid));
	    mav.setViewName("sendmessage");
	    return mav;
	  }
	
	 @RequestMapping(value="/saveMessage",method=RequestMethod.POST)
     public ModelAndView saveMessage(HttpServletRequest request,
    		 @RequestParam("title") String title,
    		 @RequestParam("receiverid") String receiverid,
    		 @RequestParam("content") String content,
            @RequestParam("file") MultipartFile file,
            HttpSession session) throws Exception {
//		service=new IndexService();
        
        //如果文件不为空，写入上传路径
		String filename="";
        if(!file.isEmpty()) {
            //上传文件路径
            String path = request.getServletContext().getRealPath("/files/");
            System.out.print("路径："+path);
            //上传文件名
            filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) { 
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
        } 
        String tmp[]=receiverid.split(",");
        for(String t:tmp)
        {
        	Message message=new Message();
        	message.setContent(content);
        	message.setReceiverdelete(0);
        	message.setReceiverid(Integer.valueOf(t));
        	User receiver=indexService.getUserById(Integer.valueOf(t));
        	message.setReceivername(receiver.getName());
        	message.setSenddelete(0);
        	People user=(People) session.getAttribute("user");
        	message.setSendid(user.getId());
        	message.setSendname(user.getName());
        	message.setSendtime(new Date());
        	message.setTitle(title);
        	message.setFilename(filename);
        	
 //       	service=new MessageService();
        	messageService.saveMessage(message); 
        }
        return new ModelAndView("redirect:/message/outbox.html");
        

     }
	 @RequestMapping(value = "deleteInMessage.html", method = RequestMethod.GET)
	  public ModelAndView deleteInMessage(@RequestParam("id") Integer id) {
//		 service=new MessageService();
		 messageService.deleteInMessage(id);
		return new ModelAndView("redirect:/message/inbox.html");
	  }
	 @RequestMapping(value = "deleteOutMessage.html", method = RequestMethod.GET)
	  public ModelAndView deleteOutMessage(@RequestParam("id") Integer id) {
//		 service=new MessageService();
		 messageService.deleteOutMessage(id);
		return new ModelAndView("redirect:/message/outbox.html");
	  }
	 @RequestMapping(value = "getMessage.html", method = RequestMethod.GET)
	  public ModelAndView getMessage(@RequestParam("id") Integer id) {
//		 service=new MessageService();
		Message message=messageService.getMessage(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", message);
	    mav.setViewName("messagedetail");
	    return mav;
	  }
	 @RequestMapping(value = "messagedetail.html")
	  public ModelAndView messagedetail(HttpSession session) {
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("messagedetail");
	   
	    return mav;
	  }
	 @RequestMapping(value = "downloadFile.html")
	  public void downloadFile(HttpServletResponse response,HttpServletRequest request, @RequestParam("id") Integer id)
	      throws UnsupportedEncodingException {
//		 service=new MessageService();
		 Message message=messageService.getMessage(id);
		 messageService.downloadFile(message.getFilename(), response,request);

	  }
}
