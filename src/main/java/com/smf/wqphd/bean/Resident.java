package com.smf.wqphd.bean;

import lombok.Data;

@Data
public class Resident {

  private int p_Id;
  private String p_Name;
  private String p_Telephone;
  private String p_Card;
  private String p_Email;
  ///多表查询结果
  private String h_Status ;
  private  String h_Case;
  private int a_Id;
//  private java.sql.Timestamp c_reateTime;
//  private java.sql.Timestamp u_pdateTime;


}
