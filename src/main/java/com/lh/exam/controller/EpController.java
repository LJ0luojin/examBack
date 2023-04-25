package com.lh.exam.controller;

import com.lh.exam.api.CommonResult;
import com.lh.exam.entity.Ep;
import com.lh.exam.entity.Question;
import com.lh.exam.mapper.QuestionMapper;
import com.lh.exam.pojo.Grade;
import com.lh.exam.pojo.PaperOption;
import com.lh.exam.service.EpService;
import com.lh.exam.service.ExamService;
import com.lh.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("kg")
public class EpController {
    @Autowired
    private EpService epService;

    @Autowired
    private ExamService examService;
    @Autowired
    private QuestionService questionService;

    /**
     * 获取试卷列表
     * @return
     */
    @RequestMapping("/gettabledata")
    public CommonResult getTableDate(){
        //获取考试列表中的所有考试
        ArrayList<Ep> tableData = epService.getTableData();
        if(tableData==null){
            return CommonResult.failed("暂无考试");
        }
        return CommonResult.success(tableData);
    }

    /**
     * 获取参加该场考试的学生成绩列表
     * 返回需要有以下内容
     * 1、学号
     * 2、姓名
     * 3、状态
     * 4、成绩
     * @return
     */
    @RequestMapping("getgradelist")
    public CommonResult getGradeList(int epId){
        ArrayList<Grade> gradeList = examService.getGradeList(epId);
        if(gradeList==null || gradeList.size()==0) {
            return CommonResult.failed("查询失败或暂无考生参加该考试");
        }
        return CommonResult.success(gradeList);
    }

    /**
     * 发布试卷
     * @param ep
     * @return
     */
    @RequestMapping("/isused")
    public CommonResult isUsed(@RequestBody Ep ep){
//        System.out.println(ep.toString());
        int i = epService.updateStateToIsUsed(ep);
        if(i==0){
            return CommonResult.success("当前试卷已结束,或不存在");
        }else if(i==1){
            return CommonResult.success("修改成功");
        }
        return CommonResult.failed("未知异常");
    }

    /**
     * 删除试卷
     * @param epId
     * @return
     */
    @RequestMapping("/deleteep")
    public CommonResult deletePaper(int epId){
        int i = epService.deletePaper(epId);
        if(i==0){
            return CommonResult.success("当前试卷已删除,或不存在");
        }else if(i==1){
            return CommonResult.success("删除成功");
        }
        return CommonResult.failed("未知异常");
    }

    /**
     * 创建试卷
     * @param epName
     * @param questions
     * @return
     */
    @RequestMapping("commitpaper")
    public CommonResult creatPaper(String epName, @RequestBody List<Question> questions){
        //创建考试
        Ep ep = new Ep();
        ep.setEpName(epName);
        int epRes = epService.createPaper(ep);
        if(epRes==0)return CommonResult.failed("考试已存在");
        int epId = ep.getEpId();
        //题目操作
        for(Question question :questions){
                //题目绑定试卷id
                question.setEpId(epId);
                //questionAnswer处理
                String questionAnswer = "";
                String split = "\\-|-\\";
                for(String temp : question.getQuestionAnswers()){
                    questionAnswer+=temp+split;
                }
                question.setQuestionAnswer(questionAnswer);
                //questionOptions处理
                String questionOptionsStr = "";
                for(PaperOption paperOption : question.getQuestionOptions()){
                    questionOptionsStr+=paperOption.getLabel()+"(-:-)"+paperOption.getContent()+"\\-|-\\";
                }
                question.setQuestionOptionsStr(questionOptionsStr);
                int res = questionService.addQuestion(question);
                if(res == 0)return CommonResult.failed("创建失败！");
        }
        return CommonResult.success("创建成功");
    }

}
