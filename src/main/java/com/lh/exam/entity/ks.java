package com.lh.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 实体层 - 考生
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ks {
    int ksId;
    String ksName;
    String ksNumber;
    String ksPassword;
}
