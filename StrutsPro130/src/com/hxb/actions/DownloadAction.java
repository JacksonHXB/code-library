package com.hxb.actions;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

@SuppressWarnings("all")
public class DownloadAction{
	private InputStream is;
	private String fileName;//����ļ�������,
	
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
		is = ServletActionContext.getServletContext().getResourceAsStream("/images/" + fileName);//��ʼ��������
		//��ʾ�����ļ������ƣ�����������Ŀ�У�����µ��ļ�����һ���������ݿ��еõ��ģ����������������������
		fileName = "�����ľ�ɫeffet.png";
		byte[] bytes = fileName.getBytes("utf-8");//���ַ���תΪ�ֽ�����
		String fileName = new String(bytes, "iso-8859-1");
		return "success";
	}
}



































