package com.zcx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Sensor {
    private int sid;
    private String hostname;
//    private String interface;
    private String filter;
    private String detail_text;//外键，datail，detail
    private String encoding;
    private int last_cid;



}
