package com.zzwv.dto;

import lombok.Data;

@Data
public class Recommend {
    // id
    Integer id;
    // 题目
    String title;
    // 朝代
    String dynasty;
    //作者
    String writer;
    // 类型
    String type;
    // 内容
    String content;
    // 注释
    String remark;
    // 翻译
    String translation;
    // 赏析
    String shangxi;
}
