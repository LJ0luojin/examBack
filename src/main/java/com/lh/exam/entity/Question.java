package com.lh.exam.entity;

import com.lh.exam.pojo.PaperOption;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    int questionId;
    int epId;
    int questionType;
    String questionContent;
    int questionPoint;
    List<String> questionAnswers;
    String questionAnswer;
    List<PaperOption> questionOptions;
    String questionOptionsStr;

}
