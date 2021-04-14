package com.zcx.service;

import com.zcx.dao.TablesDao;
import com.zcx.entity.Event;
import com.zcx.entity.IpHdr;
import com.zcx.entity.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TablesSverviceImpl implements TablesService{

    @Autowired
    private TablesDao tablesDao;



    @Override
    public List<Event> tableEvents() {
        return tablesDao.tableEvents();
    }

    @Override
    public List<IpHdr> ipInfo() {
        return tablesDao.ipInfo();
    }

    @Override
    public List<Event> eventsInfo() {
        return tablesDao.eventInfo();
    }

    @Override
    public List<Sensor> sensorInfo() {
        return tablesDao.sensorInfo();
    }

    @Override
    public List<Sensor> tableSensor() {
        return tablesDao.tableSensor();
    }

    @Override
    public List<IpHdr> tableIp() {
        return tablesDao.tableIp();
    }
}
