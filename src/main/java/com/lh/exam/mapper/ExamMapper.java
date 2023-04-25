package com.lh.exam.mapper;

import com.lh.exam.entity.Exam;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface ExamMapper {
    int countJoinEpKs(int epId);
    /** 根据ep_id获取参加该场考试的成绩列表 */
    ArrayList<Exam> getGradeList(int epId);
}
