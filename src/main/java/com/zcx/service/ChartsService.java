package com.zcx.service;

import com.zcx.entity.Event;
import com.zcx.entity.IpHdr;
import com.zcx.entity.Sensor;

import java.util.List;

public interface ChartsService {
    public List<Event> queryEventfor24h();
    public List<Event> queryEvetName();
    public List<Sensor> queryCountHostname();
    public List<Event> queryAllEventA();
    public List<Event> queryAllEventE();

    public List<Event> queryAllEvent();

    public List<IpHdr> queryAllIp();
}
