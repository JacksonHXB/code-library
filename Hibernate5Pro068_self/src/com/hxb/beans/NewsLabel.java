package com.hxb.beans;

import java.util.HashSet;
import java.util.Set;

/*������Ŀʵ��*/
public class NewsLabel {
	private Integer id;
	private String name;
	private String content;
	private NewsLabel parentNewsLabel;//����Ŀ
	private Set<NewsLabel> childNewsLabels;//����Ŀ
	
	public NewsLabel(){
		childNewsLabels = new HashSet<NewsLabel>();
	}
	public NewsLabel(String name, String content) {
		this();
		this.name = name;
		this.content = content;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public NewsLabel getParentNewsLabel() {
		return parentNewsLabel;
	}
	public void setParentNewsLabel(NewsLabel parentNewsLabel) {
		this.parentNewsLabel = parentNewsLabel;
	}
	public Set<NewsLabel> getChildNewsLabels() {
		return childNewsLabels;
	}
	public void setChildNewsLabels(Set<NewsLabel> childNewsLabels) {
		this.childNewsLabels = childNewsLabels;
	}
	
	//����ֻ��Ҫѡ��һ�����
	@Override
	public String toString() {
		return "NewsLabel [id=" + id + ", name=" + name + ", content=" + content + ", childNewsLabels="
				+ childNewsLabels + "]";
	}
}






























