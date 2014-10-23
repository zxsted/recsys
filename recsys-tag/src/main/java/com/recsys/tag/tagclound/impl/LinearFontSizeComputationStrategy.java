package com.recsys.tag.tagclound.impl;

import com.recsys.tag.tagclound.FontSizeComputationStrategy;

/**
 * 线性大小字体生成策略类
 * @author huchao
 *
 */
public class LinearFontSizeComputationStrategy extends FontSizeComputationStrategyImpl implements FontSizeComputationStrategy {
 
    public LinearFontSizeComputationStrategy(int numSizes, String prefix) {
       super(numSizes,prefix);
    }
 
    protected double scaleCount(double count) {
        return  count;
    }
}
