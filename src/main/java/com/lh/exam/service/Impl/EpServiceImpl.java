package com.lh.exam.service.Impl;

import com.lh.exam.entity.Ep;
import com.lh.exam.mapper.EpMapper;
import com.lh.exam.mapper.ExamMapper;
import com.lh.exam.service.EpService;
import javafx.scene.input.DataFormat;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.ArrayList;

@Service
public class EpServiceImpl implements EpService {
    @Autowired
    private EpMapper epMapper;
    @Autowired
    private ExamMapper examMapper;
    @Override
    public int updateStateToIsUsed(Ep ep) {
        return epMapper.updateStateToIsUsed(ep);
    }

    @Override
    public int deletePaper(int epId) {
        return epMapper.deletePaper(epId);
    }

    @Override
    public ArrayList<Ep> getTableData() {
        ArrayList<Ep> tableData = epMapper.getTableData();
        String format = "yyyy-MM-dd HH:mm:ss";
        for(Ep ep:tableData){
            if(ep.getEpStart()!=null && ep.getEpEnd()!=null){
                //根据考试开始时间和结束时间，去生成 TimeToString。
                String time = DateFormatUtils.format(ep.getEpStart(),format);
                time += " ~ "+DateFormatUtils.format(ep.getEpEnd(),format);
                //根据试卷id获取参与考生人数
                ep.setEpTime(time);
                ep.setEpKsSum(examMapper.countJoinEpKs(ep.getEpId()));
            }
        }
        return tableData;
    }

    @Override
    public int createPaper(Ep ep) {
        return epMapper.createPaper(ep);
    }
}
