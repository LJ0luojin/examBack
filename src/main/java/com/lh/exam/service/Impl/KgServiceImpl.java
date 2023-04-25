package com.lh.exam.service.Impl;

import com.lh.exam.entity.Kg;
import com.lh.exam.mapper.KgMapper;
import com.lh.exam.service.KgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KgServiceImpl implements KgService {
    @Autowired
    private KgMapper kgMapper;
    @Override
    public Kg selectKgForUsername(Kg kg) {
        return kgMapper.selectKgForUsername(kg);
    }
}
