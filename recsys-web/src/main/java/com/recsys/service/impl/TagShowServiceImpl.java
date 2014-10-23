package com.recsys.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.recsys.base.bean.TagBean;
import com.recsys.service.TagShowService;
import com.recsys.vo.ShowResultVo;

public class TagShowServiceImpl implements TagShowService<TagBean>{

	@Override
	public ShowResultVo<TagBean> query(String tag, int sortType,int pageNO, int pageSize) {
		ShowResultVo<TagBean> result = new ShowResultVo<TagBean>();
		List<TagBean> tagList = new ArrayList<TagBean>();
		TagBean aBean = new TagBean();aBean.setId(new Long(1));aBean.setName("斯坦福大学");
		TagBean bBean = new TagBean();bBean.setId(new Long(1));bBean.setName("加州理工");
		tagList.add(aBean);
		tagList.add(bBean);
		result.setTagList(tagList);
		result.setPageNO(1);
		result.setPageSize(25);
		result.setTotalNum(50);
		return result;
	}


}
