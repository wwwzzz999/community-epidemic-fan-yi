package com.smf.wqphd.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResMsg {
    private String errcode="0";
    private String errmsg;
    private Object result;
}
