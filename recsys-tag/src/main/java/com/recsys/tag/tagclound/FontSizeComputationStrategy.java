package com.recsys.tag.tagclound;

import java.util.List;

/**
 * 字体策略接口
 * @author huchao
 *
 */
public interface FontSizeComputationStrategy {
	
	/** 计算标签字体大小  */
    public void computeFontSize(List<TagCloudElement> elements);
    
}
