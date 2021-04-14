package com.zcx.dao;

import com.zcx.entity.Event;
import com.zcx.entity.IpHdr;
import com.zcx.entity.Sensor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChartsDao {
    List<Event> queryEventfor24h();

    List<Event> queryEventName();

    List<Sensor> queryCountHostname();

    public List<Event> queryAllEventA();
    public List<Event> queryAllEventE();

    public List<IpHdr> queryAllIp();
    public List<Event> queryAllEvent();
}
