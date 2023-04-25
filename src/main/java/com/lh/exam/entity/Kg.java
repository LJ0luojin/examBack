package com.lh.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 实体层 - 考官
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kg {
    int kgId;
    String kgUsername;
    String kgPassword;
}
