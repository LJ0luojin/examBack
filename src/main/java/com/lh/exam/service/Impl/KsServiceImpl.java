package com.lh.exam.service.Impl;

import com.lh.exam.entity.Ks;
import com.lh.exam.mapper.KsMapper;
import com.lh.exam.service.KsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KsServiceImpl implements KsService {
    @Autowired
    private KsMapper ksMapper;
    @Override
    public Ks selectKsForNumber(String ksNumber) {
        return ksMapper.selectKsForNumber(ksNumber);
    }

    @Override
    public Ks selectKsForId(int ksId) {
        return ksMapper.selectKsForId(ksId);
    }

    @Override
    public int insertKs(Ks newKs) {
        return ksMapper.insertKs(newKs);
    }

    @Override
    public List<Ks> selectKs(String selectks) {
        return ksMapper.selectKs(selectks);
    }

    @Override
    public List<Ks> selectAllKs() {
        return ksMapper.selectAllKs();
    }
}
