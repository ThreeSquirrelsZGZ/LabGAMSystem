/**
 * BBD Service Inc All Rights Reserved @2018
 */

package com.xafdy.dto;

import java.util.Date;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;


/**
 * @author hebiao
 * @version $Id:SMail.java, v0.1 2018/5/19 16:59 hebiao Exp $$
 */
public class SMail {

  private final SimpleMailMessage sm = new SimpleMailMessage();

  /**
   * 简单的文本邮件
   */
  public SimpleMailMessage siMessage(String from, String[] to,
      String subject, String message) {
    sm.setFrom(from);
    sm.setTo(to);
    sm.setSubject(subject);
    sm.setText(message);
    sm.setSentDate(new Date());
    return sm;
  }

  /**
   * 发送带附件的邮件
   *
   * @param mailSender 发件人
   * @param to 收件人
   * @param text 发送文本
   * @param subject 发送主题
   */
  public MimeMessage mimeMessage(JavaMailSenderImpl mailSender, String[] to,
      String text, String subject) throws Exception {
    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper mHelper = new MimeMessageHelper(message, true, "utf8");
    mHelper.setFrom(mailSender.getUsername());
    mHelper.setTo(to);
    mHelper.setSubject(subject);
    mHelper.setText(text);
    ClassPathResource file = new ClassPathResource("/file/readme.wps");//文件位于classes下的file目录下
    System.out.println(file.getInputStream());
    mHelper.addAttachment("readme.wps", file);
    return message;

  }

  /**
   * 发送带图片的网页
   *
   * @param mailSender 发件人
   * @param to 收件人
   * @param subject 发送主题
   * @param html 发送的网页文本
   */
  public MimeMessage miMessage(JavaMailSenderImpl mailSender, String[] to,
      String subject, String html) throws MessagingException {
    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,
        true, "utf8");
    mimeMessageHelper.setFrom(mailSender.getUsername());
    mimeMessageHelper.setTo(to);
    mimeMessageHelper.setSubject(subject);
    mimeMessageHelper.setText(html, true);
    ClassPathResource file = new ClassPathResource("file/1.png");
    mimeMessageHelper.addInline("file", file);//‘file’为contentId的标示符号
    return message;

  }

}
