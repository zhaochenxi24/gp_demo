package com.zcx.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcx.entity.Event;
import com.zcx.entity.IpHdr;
import com.zcx.entity.Sensor;
import com.zcx.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class TablesController {
    @Autowired
    private TablesService tablesService;
    IpHdr ipHdr = null;


    @GetMapping("/tables")
    public String tables(Model model) {
        List<Event> tableEvents = tablesService.tableEvents();
        List<IpHdr> tableIp = tablesService.tableIp();
        List<Sensor> tableSensor = tablesService.tableSensor();
        ;

        //ip表二数据
        IpHdr ipHdr = null;
        List<IpHdr> it = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < tableIp.size(); i++) {
            ipHdr = tableIp.get(i);
            String ipver = ipHdr.getIp_ver();
            String ipsrc =longToIp(ipHdr.getIp_src());
            ipHdr.setS_ipsrc(ipsrc);
            //切割ip地址值 存入对象数组

            if (ipver.equals("4")) {
                ipHdr.setIp_ver("ipv4");
            } else if (ipver.equals("6")) {
                ipHdr.setIp_ver("ipv6");
            }
            it.add(ipHdr);

        }



        //event表三的数据
        Sensor sensor = null;
        List<Sensor> ts = new ArrayList<>();

        for (int i = 0; i < tableSensor.size(); i++) {
            sensor = tableSensor.get(i);
            String hostname = sensor.getHostname();
            String detail = sensor.getDetail_text();
            if (hostname.equals("PLUVIOPHILE:{95E6E5E3-7B60-4944-829B-C2301DEBC9DA}")) {
                sensor.setHostname("WLAN 2");
                if (detail.equals("full")) {
                    sensor.setDetail_text("全面检查");
                } else {
                    sensor.setDetail_text("快速检查");
                }
                sensor.setHostname("WLAN 2");

            } else if (tableSensor.get(i).getHostname().equals("PLUVIOPHILE:{4A8A40E4-9CCC-43ED-873C-FA8EDAB24DE5}")) {
                sensor.setHostname("Vnet 8");
                if (detail.equals("full")) {
                    sensor.setDetail_text("全面检查");
                } else {
                    sensor.setDetail_text("快速检查");
                }

            } else if (tableSensor.get(i).getHostname().equals("PLUVIOPHILE:{E050CA78-47C0-4AB4-86E6-37DEE4BFE75A}")) {
                sensor.setHostname("宽带连接");
                if (detail.equals("full")) {
                    sensor.setDetail_text("全面检查");
                } else {
                    sensor.setDetail_text("快速检查");
                }

            } else if (tableSensor.get(i).getHostname().equals("PLUVIOPHILE:{0B4C6077-2BD4-4A81-9344-6D6D5CC02627}")) {
                sensor.setHostname("蓝牙连接");
                if (detail.equals("full")) {
                    sensor.setDetail_text("全面检查");
                } else {
                    sensor.setDetail_text("快速检查");
                }
            }else if (tableSensor.get(i).getHostname().equals("PLUVIOPHILE:{12D9AFAC-B892-41B6-A059-181C342B3F0B}")) {
                sensor.setHostname("以太网");
                if (detail.equals("full")) {
                    sensor.setDetail_text("全面检查");
                } else {
                    sensor.setDetail_text("快速检查");
                }
            }
            ts.add(sensor);
        }


        model.addAttribute("tableEvents", tableEvents);
        model.addAttribute("tableIp", tableIp);
        model.addAttribute("tableSensor", ts);
        model.addAttribute("size",tableSensor.size());

        return "tables";
    }

    @GetMapping("/ipinfo")
    public String tableinfo(Model model,
                            //分页参数
                            @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                            @RequestParam(defaultValue="15",value="pageSize")Integer pageSize
    ) {

        //实现分页 上
        //为了程序的严谨性，判断非空：
        if(pageNum == null){
            pageNum = 1;   //设置默认当前页
        }
        if(pageNum <= 0){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 15;    //设置默认每页显示的数据数
        }


//1.引入分页插件,pageNum是第几页，pageSize是每页显示多少条,默认查询总数count
        PageHelper.startPage(pageNum,pageSize);
        //2.紧跟的查询就是一个分页查询-必须紧跟.后面的其他查询不会被分页，除非再次调用PageHelper.startPage
        try {
            List<IpHdr> tableIp = tablesService.ipInfo();
           // System.out.println("分页数据："+ipHdrList);
            model.addAttribute("iphdr", tableIp);
            //处理
            IpHdr ipHdr = null;
            List<IpHdr> it = new ArrayList<>();
            List<String> strings = new ArrayList<>();
            for (int i = 0; i < tableIp.size(); i++) {
                ipHdr = tableIp.get(i);

                String ipver = ipHdr.getIp_ver();
                //源地址
                String ipsrc =longToIp(ipHdr.getIp_src());
                ipHdr.setS_ipsrc(ipsrc);
                //目的地址
                String ipdst =longToIp(ipHdr.getIp_dst());
                ipHdr.setS_ipdst(ipdst);
                //ip版本
                if (ipver.equals("4")) {
                    ipHdr.setIp_ver("ipv4");
                } else if (ipver.equals("6")) {
                    ipHdr.setIp_ver("ipv6");
                }
                it.add(ipHdr);

            }



            //3.使用PageInfo包装查询后的结果,5是连续显示的条数,结果list类型是Page<E>
            PageInfo<IpHdr> pageInfo = new PageInfo<IpHdr>(tableIp,pageSize);
            //4.使用model/map/modelandview等带回前端
            model.addAttribute("pageInfo",pageInfo);
        }finally {
            PageHelper.clearPage(); //清理 ThreadLocal 存储的分页参数,保证线程安全
        }

        //下
        return "ipinfo";
    }

    @GetMapping("/eventinfo")
    public String tableinfo2(Model model,
                             //分页参数
                            @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                             @RequestParam(defaultValue="15",value="pageSize")Integer pageSize) {

        //实现分页 上
        //为了程序的严谨性，判断非空：
        if(pageNum == null){
            pageNum = 1;   //设置默认当前页
        }
        if(pageNum <= 0){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 15;    //设置默认每页显示的数据数
        }
        //System.out.println("当前页是："+pageNum+"显示条数是："+pageSize);

//1.引入分页插件,pageNum是第几页，pageSize是每页显示多少条,默认查询总数count
        PageHelper.startPage(pageNum,pageSize);
        //2.紧跟的查询就是一个分页查询-必须紧跟.后面的其他查询不会被分页，除非再次调用PageHelper.startPage
        try {
            List<Event> eventInfo = tablesService.eventsInfo();
           // System.out.println("分页数据："+eventInfo);
            model.addAttribute("eventInfo", eventInfo);
            //3.使用PageInfo包装查询后的结果,5是连续显示的条数,结果list类型是Page<E>
            PageInfo<Event> pageInfo = new PageInfo<Event>(eventInfo,pageSize);
            //4.使用model/map/modelandview等带回前端
            model.addAttribute("pageInfo",pageInfo);
        }finally {
            PageHelper.clearPage(); //清理 ThreadLocal 存储的分页参数,保证线程安全
        }

        //下

        return "eventinfo";
    }
    //分页

//分页查询数据


    //十进制转ip地址的方法
    public static String longToIp(long ip) {
        StringBuilder result = new StringBuilder(15);
        for (int i = 0; i < 4; i++) {
            result.insert(0, Long.toString(ip & 0xff));

            if (i < 3) {
                result.insert(0, '.');
            }
            ip = ip >> 8;
        }
        return result.toString();
    }
}
