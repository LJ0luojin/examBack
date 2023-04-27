package com.lh.exam.mapper;

import com.lh.exam.entity.Ks;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KsMapper {
    Ks selectKsForNumber(String ksNumber);
    Ks selectKsForId(int ksId);
    int insertKs(Ks newKs);
    List<Ks> selectKs(String selectks);
    List<Ks> selectAllKs();
}
