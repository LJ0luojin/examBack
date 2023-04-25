package com.lh.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exam {
    int examId;
    int ksId;
    int epId;
    String examStateToString;
    int examState;
    int examScore;
}
