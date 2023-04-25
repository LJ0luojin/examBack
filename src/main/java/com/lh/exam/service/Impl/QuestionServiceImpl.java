package com.lh.exam.service.Impl;

import com.lh.exam.entity.Question;
import com.lh.exam.mapper.QuestionMapper;
import com.lh.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public int addQuestion(Question question) {
        return questionMapper.addQuestion(question);
    }
}
