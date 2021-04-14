package com.zcx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TcpHdr {
    private String sid;
    private String cid;
    private String tcp_sport;
    private String tcp_dport;
    private String tcp_seq;
    private String tcp_ack;
    private String tcp_off;
    private String tcp_res;
    private String tcp_flags;
    private String tcp_win;
    private String tcp_csum;
    private String tcp_urp;
}
