package com.lh.exam.mapper;

import com.lh.exam.entity.Ep;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface EpMapper {
    int updateStateToIsUsed(Ep ep);
    int deletePaper(int epId);
    ArrayList<Ep> getTableData();
    int createPaper(Ep ep);
}
