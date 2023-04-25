package com.lh.exam.mapper;

import com.lh.exam.entity.Question;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {
    int addQuestion(Question question);
}
