package com.lh.exam.mapper;

import com.lh.exam.entity.Ks;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KSMapper {
    Ks selectKsForNumber(String ksNumber);
    Ks selectKsForId(int ksId);
    int insertKs(Ks newKs);
}
