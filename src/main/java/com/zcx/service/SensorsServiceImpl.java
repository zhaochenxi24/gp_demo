package com.zcx.service;

import com.zcx.dao.SensorsDao;
import com.zcx.entity.Event;
import com.zcx.entity.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SensorsServiceImpl implements SensorsService {
    @Autowired SensorsDao sensorsDao;


    @Override
    public List<Event> getAllEvent1() {
        return sensorsDao.getAllEvent1();
    }
    @Override
    public List<Event> getAllEvent5() {
        return sensorsDao.getAllEvent5();
    }

    @Override
    public List<Event> getEventInfo_a() {
        return sensorsDao.getEventInfo_a();
    }
    @Override
    public List<Event> getEventInfo_e() {
        return sensorsDao.getEventInfo_e();
    }
}
