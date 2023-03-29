package com.lh.exam.service;

import com.lh.exam.entity.ks;

public interface KsService {
    ks selectKsForNumber(String ksNumber);
    int insertKs(ks newKs);
}
