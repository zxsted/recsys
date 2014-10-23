package com.recsys.tag.tagclound;

import java.util.List;

/**
 * 标签云接口
 * @author huchao
 *
 */
public interface TagCloud {
	
	/** 获取标签列表  */
    public List<TagCloudElement> getTagCloudElements();
    
}
