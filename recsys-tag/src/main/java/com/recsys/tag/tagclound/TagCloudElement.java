package com.recsys.tag.tagclound;

/**
 * 标签云信息接口
 * @author huchao
 *
 */
public interface TagCloudElement extends Comparable<TagCloudElement> {
	
	/** 获取标签文本  */
    public String getTagText();
    
    /** 获取标签权重  */
    public double getWeight();
    
    /** 获取标签字体大小  */
    public String getFontSize();
    
    /** 获取标签字体大小  */
    public void setFontSize(String fontSize);
    
}
