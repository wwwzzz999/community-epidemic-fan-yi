package com.smf.wqphd.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MaterialRequire {

    private int s_id;
    private int m_id;
    private String m_name;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
//    @DateTimeFormat(pattern = "yyyy/MM/dd" )
    private Date s_send_time;

    private int s_number;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss" )
    private Date create_time;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy/MM/dd HH/mm/ss" )
    private Date update_time;
    private int a_id;


    private String c_area;
    private String d_name;
    private int r_name;
}
