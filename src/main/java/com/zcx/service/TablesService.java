package com.zcx.service;

import com.zcx.entity.Event;
import com.zcx.entity.IpHdr;
import com.zcx.entity.Sensor;

import java.util.List;

public interface TablesService {
    List<Event>tableEvents();
    List<IpHdr>tableIp();
    List<Sensor>tableSensor();
    //_________________________
    List<IpHdr>ipInfo();
    List<Event>eventsInfo();
    List<Sensor>sensorInfo();

}
