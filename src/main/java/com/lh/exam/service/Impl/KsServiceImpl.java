package com.lh.exam.service.Impl;

import com.lh.exam.entity.ks;
import com.lh.exam.mapper.KSMapper;
import com.lh.exam.service.KsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KsServiceImpl implements KsService {
    @Autowired
    private KSMapper ksLoginMapper;
    @Override
    public ks selectKsForNumber(String ksNumber) {
        return ksLoginMapper.selectKsForNumber(ksNumber);
    }

    @Override
    public int insertKs(ks newKs) {
        return ksLoginMapper.insertKs(newKs);
    }
}
