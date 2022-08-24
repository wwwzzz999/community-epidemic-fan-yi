package com.smf.wqphd.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ComeAndGo {
    private Integer o_id;
    private String o_name;
    private String o_case;
    private String o_address;

    //JsonFormat把时间转换为json字符串，并指定格式,用于数据返回到页面
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    //DateTimeFormat把字符串转为时间对象,用于数据接收
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date o_gtime;

    //JsonFormat把时间转换为json字符串，并指定格式,用于数据返回到页面
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    //DateTimeFormat把字符串转为时间对象,用于数据接收
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date o_btime;

    //JsonFormat把时间转换为json字符串，并指定格式,用于数据返回到页面
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    //DateTimeFormat把字符串转为时间对象,用于数据接收
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;

    //JsonFormat把时间转换为json字符串，并指定格式,用于数据返回到页面
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    //DateTimeFormat把字符串转为时间对象,用于数据接收
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date update_time;


    public ComeAndGo(Integer o_id, String o_name, String o_case, String o_address, Date o_gtime, Date o_btime, Date create_time, Date update_time) {
        this.o_id = o_id;
        this.o_name = o_name;
        this.o_case = o_case;
        this.o_address = o_address;
        this.o_gtime = o_gtime;
        this.o_btime = o_btime;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public ComeAndGo() {
    }

    public Integer getO_id() {
        return o_id;
    }

    public void setO_id(Integer o_id) {
        this.o_id = o_id;
    }

    public String getO_name() {
        return o_name;
    }

    public void setO_name(String o_name) {
        this.o_name = o_name;
    }

    public String getO_case() {
        return o_case;
    }

    public void setO_case(String o_case) {
        this.o_case = o_case;
    }

    public String getO_address() {
        return o_address;
    }

    public void setO_address(String o_address) {
        this.o_address = o_address;
    }

    public Date getO_gtime() {
        return o_gtime;
    }

    public void setO_gtime(Date o_gtime) {
        this.o_gtime = o_gtime;
    }

    public Date getO_btime() {
        return o_btime;
    }

    public void setO_btime(Date o_btime) {
        this.o_btime = o_btime;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "ComeAndGo{" +
                "o_id=" + o_id +
                ", o_name='" + o_name + '\'' +
                ", o_case='" + o_case + '\'' +
                ", o_address='" + o_address + '\'' +
                ", o_gtime=" + o_gtime +
                ", o_btime=" + o_btime +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
