package com.hxb.actions;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("all")
public class UploadAction{
	private File img;
	private String imgFileName;//������ֱ���Ҫһ��
	
	public String execute(){
		if(img != null){
			//��ͨ�ľ���·����String path = "D:/Test";
			//��̨����·��������ʱĿ¼�¿��Կ���
			String path = ServletActionContext.getServletContext().getRealPath("/test");
			File destFile = new File(path, imgFileName);
			try {
				FileUtils.copyFile(img, destFile);
			} catch (IOException e) {}
			return "success";
		}
		return "message";
	}
	
	public File getImg() {
		return img;
	}
	public void setImg(File img) {
		this.img = img;
	}
	public String getImgFileName() {
		return imgFileName;
	}
	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}
}







































