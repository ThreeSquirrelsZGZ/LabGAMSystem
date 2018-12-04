package com.xafdy.model;

import java.util.Date;

public class Message {
	private int id;
	private String title;
	private String content;
	private String receivername;
	private String sendname;
	private int senddelete;
	private int receiverdelete;
	private String filename;
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getSenddelete() {
		return senddelete;
	}
	public void setSenddelete(int senddelete) {
		this.senddelete = senddelete;
	}
	public int getReceiverdelete() {
		return receiverdelete;
	}
	public void setReceiverdelete(int receiverdelete) {
		this.receiverdelete = receiverdelete;
	}
	public String getReceivername() {
		return receivername;
	}
	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}
	public String getSendname() {
		return sendname;
	}
	public void setSendname(String sendname) {
		this.sendname = sendname;
	}
	private int receiverid;
	private int sendid;
	private Date sendtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReceiverid() {
		return receiverid;
	}
	public void setReceiverid(int receiverid) {
		this.receiverid = receiverid;
	}
	public int getSendid() {
		return sendid;
	}
	public void setSendid(int sendid) {
		this.sendid = sendid;
	}
	public Date getSendtime() {
		return sendtime;
	}
	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}
	
	
	
	public Message(int id, String title, String content, String receivername,
			String sendname, int senddelete, int receiverdelete,
			String filename, int receiverid, int sendid, Date sendtime) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.receivername = receivername;
		this.sendname = sendname;
		this.senddelete = senddelete;
		this.receiverdelete = receiverdelete;
		this.filename = filename;
		this.receiverid = receiverid;
		this.sendid = sendid;
		this.sendtime = sendtime;
	}
	public Message() {
		super();
	}
	
	
	
	
	
}
