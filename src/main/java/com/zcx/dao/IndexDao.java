package com.zcx.dao;

import com.zcx.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndexDao {
    List<IpHdr> queryAllIpHdr();
    List<TcpHdr> queryAllTcpHdr();
    List<UdpHdr> queryAllUdpHdr();
    List<IcmpHdr> queryAllIcmpHdr();
    List<Sensor> querySensor();
    List<Event> queryEvent();
    List<Event> queryEventfor24h();
}
