package com.zcx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IcmpHdr {
    private String sid;
    private String cid;
    private String icmp_type;
    private String icmp_code;
    private String icmp_csum;
    private String icmp_id;
    private String icmp_seq;

}
