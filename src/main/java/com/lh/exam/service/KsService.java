package com.lh.exam.service;

import com.lh.exam.entity.Ks;

public interface KsService {
    Ks selectKsForNumber(String ksNumber);
    Ks selectKsForId(int ksId);
    int insertKs(Ks newKs);
}
