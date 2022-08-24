package com.smf.wqphd.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MaterialType {

    private int m_id;
    private String m_name;
    private int m_storage;
    private String m_desc;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss" )
    private Date create_time;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss" )
    private Date update_time;


    public MaterialType(int m_id, String m_name, int m_storage, String m_desc, Date creat_time, Date update_time) {
        this.m_id = m_id;
        this.m_name = m_name;
        this.m_storage = m_storage;
        this.m_desc = m_desc;
        this.create_time = creat_time;
        this.update_time = update_time;
    }

    public MaterialType() {
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public int getM_storage() {
        return m_storage;
    }

    public void setM_storage(int m_storage) {
        this.m_storage = m_storage;
    }

    public String getM_desc() {
        return m_desc;
    }

    public void setM_desc(String m_desc) {
        this.m_desc = m_desc;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date creat_time) {
        this.create_time = creat_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "MaterialType{" +
                "m_id=" + m_id +
                ", m_name='" + m_name + '\'' +
                ", m_storage=" + m_storage +
                ", m_desc='" + m_desc + '\'' +
                ", creat_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
