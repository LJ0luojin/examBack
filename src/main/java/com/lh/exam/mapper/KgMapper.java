package com.lh.exam.mapper;

import com.lh.exam.entity.Kg;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KgMapper  {
    Kg selectKgForUsername(Kg kg);
}
