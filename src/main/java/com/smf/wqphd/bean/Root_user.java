package com.smf.wqphd.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * tab_root
 * @author 
 */

public class Root_user implements Serializable {
    private Integer u_Id;

    private String u_Name;

    private String u_Password;

    private Date create_Time;

    private Date update_Time;

    private static final long serialVersionUID = 1L;


    @Override
    public String toString() {
        return "Root_user{" +
                "u_Id=" + u_Id +
                ", u_Name='" + u_Name + '\'' +
                ", u_Password='" + u_Password + '\'' +
                ", create_Time=" + create_Time +
                ", update_Time=" + update_Time +
                '}';
    }

    public Integer getU_Id() {
        return u_Id;
    }

    public void setU_Id(Integer u_Id) {
        this.u_Id = u_Id;
    }

    public String getU_Name() {
        return u_Name;
    }

    public void setU_Name(String u_Name) {
        this.u_Name = u_Name;
    }

    public String getU_Password() {
        return u_Password;
    }

    public void setU_Password(String u_Password) {
        this.u_Password = u_Password;
    }

    public Date getCreate_Time() {
        return create_Time;
    }

    public void setCreate_Time(Date create_Time) {
        this.create_Time = create_Time;
    }

    public Date getUpdate_Time() {
        return update_Time;
    }

    public void setUpdate_Time(Date update_Time) {
        this.update_Time = update_Time;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Root_user() {
    }

    public Root_user(Integer u_Id, String u_Name, String u_Password, Date create_Time, Date update_Time) {
        this.u_Id = u_Id;
        this.u_Name = u_Name;
        this.u_Password = u_Password;
        this.create_Time = create_Time;
        this.update_Time = update_Time;
    }
}