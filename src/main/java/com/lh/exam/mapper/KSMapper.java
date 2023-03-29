package com.lh.exam.mapper;

import com.lh.exam.entity.ks;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KSMapper {
    ks selectKsForNumber(String ksNumber);
    int insertKs(ks newKs);
}
