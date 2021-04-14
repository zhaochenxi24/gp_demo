package com.zcx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IpTable {
    //iphdr数据表
    private String ip_src;
    private String sid;
    private int cid;
    private String ip_dst;
    private String ip_ver;
    private String ip_hlen;
    private String ip_tos;
    private String ip_len;
    private String ip_id;
    private String ip_flags;
    private String ip_off;
    private String ip_ttl;
    private String ip_proto;
    private String ip_csum;
}
