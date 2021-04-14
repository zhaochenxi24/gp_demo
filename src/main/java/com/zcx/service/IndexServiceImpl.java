package com.zcx.service;

import com.zcx.dao.IndexDao;
import com.zcx.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IndexServiceImpl implements IndexService{

    @Autowired
    private IndexDao indexDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<IpHdr> queryAllIpHdr() {
        return indexDao.queryAllIpHdr();
    }

    @Override
    public List<TcpHdr> queryAllTcpHdr() {
        return indexDao.queryAllTcpHdr();
    }

    @Override
    public List<UdpHdr> queryAllUdphdr() {
        return indexDao.queryAllUdpHdr();
    }

    @Override
    public List<IcmpHdr> queryAllIcmpHdr() {
        return indexDao.queryAllIcmpHdr();
    }

    @Override
    public List<Sensor> querySensor() {
        return indexDao.querySensor();
    }

    @Override
    public List<Event> queryEvent() {
        return indexDao.queryEvent();
    }

    @Override
    public List<Event> queryEventfor24h() {
        return indexDao.queryEventfor24h();
    }
}
