package com.zcx.service;

import com.zcx.dao.ChartsDao;
import com.zcx.dao.IndexDao;
import com.zcx.entity.Event;
import com.zcx.entity.IpHdr;
import com.zcx.entity.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ChartsServiceImpl implements ChartsService{

    @Autowired
    private ChartsDao chartsDao;

    @Override
    public List<Sensor> queryCountHostname() {
        return chartsDao.queryCountHostname();
    }

    @Override
    public List<Event> queryAllEventA() {
        return chartsDao.queryAllEventA();
    }

    @Override
    public List<Event> queryAllEvent() {
        return chartsDao.queryAllEvent();
    }

    @Override
    public List<IpHdr> queryAllIp() {
        return chartsDao.queryAllIp();
    }

    @Override
    public List<Event> queryAllEventE() {
        return chartsDao.queryAllEventE();
    }

    @Override
    public List<Event> queryEvetName() {
        return chartsDao.queryEventName();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Event> queryEventfor24h() {
        return chartsDao.queryEventfor24h();
    }
}
