package com.zcx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Signature {
    private String sig_id;
    private String sig_name;
    private String sig_class_name;
    private String sig_priority;
    private String sig_rev;
    private String sig_sid;
    private String sig_gid;
}
