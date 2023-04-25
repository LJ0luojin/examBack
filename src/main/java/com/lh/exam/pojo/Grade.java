package com.lh.exam.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    String ksNumber;
    String ksName;
    String examState;
    int examScore;
}
