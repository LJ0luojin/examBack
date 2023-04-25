package com.lh.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 试卷
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ep {
    int epId;
    String epName;
    String epTime;
    Date epStart;
    Date epEnd;
    int epKsSum;
    String epState;
}
