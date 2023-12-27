package com.office.library.dto;

import lombok.Data;

@Data
public class HopeBookDto {
    private int hb_no;
    private int u_m_no;
    private String hb_name;
    private String hb_author;
    private String hb_publisher;
    private int hb_publish_year;
    private String hb_reg_date;
    private String hb_mod_date;
    private int hb_result;
    private String hb_result_last_date;

    String u_m_id;
    String u_m_pw;
    String u_m_name;
    String u_m_gender;
    String u_m_mail;
    String u_m_phone;
    String u_m_reg_date;
    String u_m_mod_date;
}