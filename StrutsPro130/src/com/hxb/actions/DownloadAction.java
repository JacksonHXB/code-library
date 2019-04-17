package com.hxb.actions;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

@SuppressWarnings("all")
public class DownloadAction{
	private InputStream is;
	private String fileName;//这个文件名随意,
	
	public InputStream getIs() {
		return is;
	}
	public void setIs(InputStream is) {
		this.is = is;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String execute() throws Exception{
		fileName = "p1.png";
		is = ServletActionContext.getServletContext().getResourceAsStream("/images/" + fileName);//初始化输入流
		//显示下载文件的名称，在真正的项目中，这个新的文件名称一般是由数据库中得到的，而且这里会出现乱码的问题
		fileName = "美丽的景色effet.png";
		byte[] bytes = fileName.getBytes("utf-8");//将字符串转为字节数组
		String fileName = new String(bytes, "iso-8859-1");
		return "success";
	}
}



































