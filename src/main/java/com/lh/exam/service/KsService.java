package com.lh.exam.service;

import com.lh.exam.entity.Ks;

import java.util.List;

public interface KsService {
    Ks selectKsForNumber(String ksNumber);
    Ks selectKsForId(int ksId);
    int insertKs(Ks newKs);
    List<Ks> selectKs(String selectks);
    List<Ks> selectAllKs();
}
