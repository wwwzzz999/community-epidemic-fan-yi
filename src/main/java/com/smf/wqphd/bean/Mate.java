package com.smf.wqphd.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Mate {
   String m_name;
   int d_number;
   @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
   Date s_send_time;
   String m_desc;
}
