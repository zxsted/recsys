package com.recsys.base.cache.inf;

import java.io.Serializable;

public interface Cacheable extends Serializable {

    /**
     * 判断cache对象是否为空对象
     * 如果为空对象,return true;
     * 否则,返回false;
     * 
     */
    public boolean isNull();
    
}