package com.zcx.dao;

import com.zcx.entity.Event;
import com.zcx.entity.IpHdr;
import com.zcx.entity.Sensor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface TablesDao {
    List<Event> tableEvents();
    List<IpHdr> tableIp();
    List<Sensor> tableSensor();
    //________
    List<IpHdr> ipInfo();
    List<Event> eventInfo();
    List<Sensor> sensorInfo();




}
