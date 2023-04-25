package com.lh.exam.service.Impl;

import com.lh.exam.entity.Exam;
import com.lh.exam.entity.Ks;
import com.lh.exam.mapper.ExamMapper;
import com.lh.exam.mapper.KSMapper;
import com.lh.exam.pojo.Grade;
import com.lh.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamMapper examMapper;
    @Autowired
    private KSMapper ksMapper;
    @Override
    public int countJoinEpKs(int epId) {
        return examMapper.countJoinEpKs(epId);
    }

    @Override
    public ArrayList<Grade> getGradeList(int epId) {
        //创建返回对象
        ArrayList<Grade> grades = new ArrayList<>();
        Ks ks = new Ks();
        //获取所有参加该考试的考生
        ArrayList<Exam> gradeList = examMapper.getGradeList(epId);
        for(Exam exam : gradeList){
            //查找参与考试的考生信息
            ks = ksMapper.selectKsForId(exam.getKsId());
            Grade tempGrade = new Grade();
            //写入返回对象中
            tempGrade.setKsNumber(ks.getKsNumber());
            tempGrade.setKsName(ks.getKsName());
            if(exam.getExamState()==0){
                tempGrade.setExamState("未开始");
            }else if(exam.getExamState()==1){
                tempGrade.setExamState("进行中");
            } else if (exam.getExamState()==2) {
                tempGrade.setExamState("已提交");
                tempGrade.setExamScore(exam.getExamScore());
            } else if (exam.getExamState()==3) {
                tempGrade.setExamState("缺考");
                tempGrade.setExamScore(0);
            }else{
                tempGrade.setExamState("状态异常");
            }
            grades.add(tempGrade);
        }
        return grades;
    }
}
