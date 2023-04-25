package com.lh.exam.service;

import com.lh.exam.entity.Exam;
import com.lh.exam.pojo.Grade;

import java.util.ArrayList;

public interface ExamService {
    int countJoinEpKs(int epId);
    ArrayList<Grade> getGradeList(int epId);
}
