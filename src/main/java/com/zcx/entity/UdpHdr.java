package com.zcx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UdpHdr {
    private String sid;
    private String cid;
    private String udp_sport;
    private String udp_dport;
    private String udp_len;
    private String udp_csum;
}
