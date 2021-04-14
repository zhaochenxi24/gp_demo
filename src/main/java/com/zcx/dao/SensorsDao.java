package com.zcx.dao;

import com.zcx.entity.Event;
import com.zcx.entity.Sensor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SensorsDao {

    List<Event> getAllEvent1();
    List<Event> getAllEvent5();
    List<Event> getEventInfo_a();
    List<Event> getEventInfo_e();
}
