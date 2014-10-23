package com.recsys.vo;

import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.recsys.base.cache.inf.Cacheable;

public class ShowResultVo<T> implements Cacheable {

	private static final long serialVersionUID = 1041299266061324472L;
	private long totalNum;

	public int getTotalPage() {
		return this.totalNum % this.pageSize == 0 ? (int) this.totalNum / this.pageSize : ((int) this.totalNum / this.pageSize) + 1;
	}

	private int pageSize;

	private int pageNO;
	
	private List<T> tagList;

	public long getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(long totalNum) {
		this.totalNum = totalNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNO() {
		return pageNO;
	}

	public void setPageNO(int pageNO) {
		this.pageNO = pageNO;
	}
	
	public List<T> getTagList() {
		return tagList;
	}

	public void setTagList(List<T> tagList) {
		this.tagList = tagList;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
	@Override
	public boolean isNull() {
		// TODO Auto-generated method stub
		return false;
	}

}
