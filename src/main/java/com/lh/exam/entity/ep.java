package com.lh.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 试卷
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ep {
    int epId;
    String epName;
    Date epStart;
    Date epEnd;
    int epKsSum;
}
