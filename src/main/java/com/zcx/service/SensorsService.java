package com.zcx.service;

import com.zcx.entity.Event;
import com.zcx.entity.Sensor;

import java.util.List;

public interface SensorsService {
    public List<Event> getAllEvent1();
    public List<Event> getAllEvent5();

    public List<Event> getEventInfo_a();
    public List<Event> getEventInfo_e();
}
