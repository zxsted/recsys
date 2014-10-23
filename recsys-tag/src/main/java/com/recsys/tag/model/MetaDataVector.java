package com.recsys.tag.model;

import java.util.List;

public interface MetaDataVector {
    public List<TagMagnitude> getTagMetaDataMagnitude() ;
    public double dotProduct(MetaDataVector other);
    public double distance(MetaDataVector other) ;
    public MetaDataVector add(MetaDataVector other);	
    public MetaDataVector add(MetaDataVector other, double otherScale);
}
