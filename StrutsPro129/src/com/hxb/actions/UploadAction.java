package com.hxb.actions;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("all")
public class UploadAction{
	private File[] imgs;
	private String[] imgsFileName;//������ֱ���Ҫһ��
	
	public String execute(){
		//���û�û��ѡ���κ��ϴ����ļ�ʱ��imgs����û�н��д���
		if(imgs != null){
			for (int i = 0; i < imgs.length; i++) {
				String path = ServletActionContext.getServletContext().getRealPath("/test");
				File destFile = new File(path, imgsFileName[i]);
				try {
					FileUtils.copyFile(imgs[i], destFile);
				} catch (IOException e) {}
			}
			return "success";
		}
		return "message";
	}

	public File[] getImgs() {
		return imgs;
	}
	public void setImgs(File[] imgs) {
		this.imgs = imgs;
	}
	public String[] getImgsFileName() {
		return imgsFileName;
	}
	public void setImgsFileName(String[] imgsFileName) {
		this.imgsFileName = imgsFileName;
	}
}







































