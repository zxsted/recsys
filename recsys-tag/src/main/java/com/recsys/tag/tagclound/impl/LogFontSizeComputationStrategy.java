package com.recsys.tag.tagclound.impl;

import com.recsys.tag.tagclound.FontSizeComputationStrategy;

/**
 * 取对数生成字体大小策略类
 * @author huchao
 *
 */
public class LogFontSizeComputationStrategy  extends FontSizeComputationStrategyImpl
    implements FontSizeComputationStrategy {

    public LogFontSizeComputationStrategy(int numSizes, String prefix) {
       super(numSizes,prefix);
    }

    protected double scaleCount(double count) {
        return  Math.log10(count);
    }
}
