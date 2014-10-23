package com.recsys.service;

import com.recsys.vo.ShowResultVo;

public interface TagShowService<T> {

	ShowResultVo<T> query(String tag, int sortType, int pageNO, int pageSize);
	
}
