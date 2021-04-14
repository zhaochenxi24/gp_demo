package com.zcx.service;

import com.zcx.entity.*;

import java.util.List;

public interface IndexService {
    //数据表iphdr
    List<IpHdr> queryAllIpHdr();
    //数据表tcphdr
    List<TcpHdr> queryAllTcpHdr();
    //数据表udphd
    List<UdpHdr> queryAllUdphdr();
    //数据表icmphdr
    List<IcmpHdr> queryAllIcmpHdr();
    //数据表传感器
    List<Sensor> querySensor();
    //数据表报警
    List<Event> queryEvent();
    //数据表报警
    List<Event> queryEventfor24h();
}
