package com.recsys.tag.tagclound;

/**
 * 可视化标签云装饰器
 * @author huchao
 *
 */
public interface VisualizeTagCloudDecorator {
	
	/** 装饰标签 */
    public String decorateTagCloud(TagCloud tagCloud);
    
}
