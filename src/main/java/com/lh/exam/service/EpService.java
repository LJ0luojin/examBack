package com.lh.exam.service;

import com.lh.exam.entity.Ep;

import java.util.ArrayList;

public interface EpService {

    int updateStateToIsUsed(Ep ep);
    int deletePaper(int epId);
    ArrayList<Ep> getTableData();
    int createPaper(Ep ep);
}
