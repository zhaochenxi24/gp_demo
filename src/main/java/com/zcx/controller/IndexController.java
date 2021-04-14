package com.zcx.controller;

import com.zcx.entity.*;
import com.zcx.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.text.SimpleDateFormat;
import java.util.*;


@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;



    @RequestMapping("/index")
    public String index (Model model) throws Exception{
        /**
         *  对iphdr数据表进行操作——————————————————————————————————————————————————
         *         model.addAttribute类似与request.setAttribute传对象到前端.
         *         ipHdrs.get(x)如ipHdrs.get(ipHdrs.size()-1)最后一行取出某一行后就能直接调用相关字段的数据
         */

        /**
         * 所有需要数据的数组封装
         */
        List<IpHdr> ipHdrs = indexService.queryAllIpHdr();
        List<TcpHdr> tcpHdrs = indexService.queryAllTcpHdr();
        List<UdpHdr> udpHdrs = indexService.queryAllUdphdr();
        List<IcmpHdr> icmpHdrs = indexService.queryAllIcmpHdr();
        List<Sensor> sensors = indexService.querySensor();
        List<Event> events = indexService.queryEvent();
        List<Event> eventfor24h = indexService.queryEventfor24h();

        /**
         * 对Sensor数据表的操作——————————————————————————————————————————————————
         * sensornum数据条数，传感器个数
         */
        int sensornum = sensors.size();
        model.addAttribute("sensornum",sensornum);
        //告警种类的统计
        long[] event_type = new long[events.size()];
        for (int i = 0; i < events.size(); i++) {
            event_type[i] = events.get(i).getSignature();
        }
        model.addAttribute("event_type",arraycount(event_type));
        /**
         * 对Event数据表的操作——————————————————————————————————————————————————
         * Eventnum数据条数，传感器个数
         */
        int eventnum = events.size();
        model.addAttribute("eventnum",eventnum);

        //源ip地址数和目的ip地址数**************************************************
        //ipsrc
        long[] ipsrc = new long[ipHdrs.size()];
        for (int i = 0; i < ipHdrs.size(); i++) {
            ipsrc[i] = ipHdrs.get(i).getIp_src();
        }

        model.addAttribute("ipsrc",arraycount(ipsrc));
        //ipdst
        long[] ipdst = new long[ipHdrs.size()];
        for (int i = 0; i < ipHdrs.size(); i++) {
            ipdst[i] = ipHdrs.get(i).getIp_dst();
        }
        model.addAttribute("ipdst",arraycount(ipdst));

        //总数ip_totel
        int ip_totel = ipHdrs.size();
        //进度条百分比
        float tcp_total = tcpHdrs.size();
        int tcp_percentage = (int) ((tcp_total/ip_totel)*100);
        float udp_total = udpHdrs.size();
        int udp_percentage = (int) ((udp_total/ip_totel)*100);
        float icmp_total = icmpHdrs.size();
        int icmp_percentage = (int) ((icmp_total/ip_totel)*100);
        model.addAttribute("tcp_percentage",tcp_percentage);
        model.addAttribute("udp_percentage",udp_percentage);
        model.addAttribute("icmp_percentage",icmp_percentage);
        int max=100,min=1;
        long randomNum = System.currentTimeMillis();
//        int ran3 = (int) (randomNum%(max-min)+min);
//        System.out.println(ran3);
//
//        model.addAttribute("a",ran3);
        //表一数据————————————————————————————————————————————————————————————————————

        //转了格式的当前时间formatDate
        Date today = new Date();//获取今天的日期
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = df.format(today);
        Calendar c = Calendar.getInstance();

        c.setTime(today);
        c.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = c.getTime();//这是昨天
        String formatDate1 = df.format(yesterday);

        c.setTime(today);
        c.add(Calendar.DAY_OF_MONTH, -2);
        Date before_yesterday = c.getTime();//这是前天
        String formatDate2 = df.format(before_yesterday);


        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getTimestamp().substring(0, 10).equals(formatDate)){
                count1++;
            }else if(events.get(i).getTimestamp().substring(0, 10).equals(formatDate1)){
                count2++;
            }else if(events.get(i).getTimestamp().substring(0, 10).equals(formatDate2)){
                count3++;
            }
        }

        model.addAttribute("count1",count1);
        model.addAttribute("count2",count2);
        model.addAttribute("count3",count3);
        //表二数据————————————————————————————————————————————————————————————————————
        /**
         * 取出小时使用sql语句
         *         System.out.println(events.get(20).getTimestamp().substring(11,13));数据库的时间
         *         System.out.println(formatDate3.substring(0,2));现在的时间
         */

        model.addAttribute("eventfor24", ((double)(eventfor24h.size())/1000));
        //表三数据————————————————————————————————————————————————————————————————————
        long[] temp = new long[ipHdrs.size()];
//        获得ip数组列 在iphosts中奇数位是10进制ip地址，偶数位是-1位ip警告的数量
        for (int i = 0; i < ipHdrs.size(); i++) {
            temp[i] = ipHdrs.get(i).getIp_src();
        }
        long[] iphosts = new long[count(arraycount1(temp))];
        for (int i = 0; i < count(arraycount1(temp)); i++) {
           iphosts[i] = arraycount1(temp)[i];
        }
        String[] ip = new String[(iphosts.length/2)];
        int count = 0;
        //将信息存入map集合
        HashMap<Long, Long> hashMap = new HashMap<>();
        for (int i = 0; i < iphosts.length; i+=2) {
            hashMap.put(iphosts[i],iphosts[i+1]);
        }
        ArrayList<Map.Entry<Long,Long>> entries= sortMap(hashMap);
        model.addAttribute("ip1",longToIp(entries.get(0).getKey()));
        model.addAttribute("ip2",longToIp(entries.get(1).getKey()));
        model.addAttribute("ip3",longToIp(entries.get(2).getKey()));

        model.addAttribute("num1",entries.get(0).getValue());
        model.addAttribute("num2",entries.get(1).getValue());
        model.addAttribute("num3",entries.get(2).getValue());





        //____________________________________返回值
        return "index";
//        return "index::part1";
    }
    //计算一维数组不同元素个数的方法
     public static int arraycount(long[] ipsrc){
        //计算一维数组的长度
        int n = ipsrc.length;
        //将数组拷贝到新的地址，这样对新数组操作不会改变原数组
        long[] tmp = new long[n];
        System.arraycopy(ipsrc, 0, tmp, 0, n);
        //统计元素种类数
        int Num = 1;
        //将数组按元素大小重新排序
        Arrays.sort(tmp);
        for (int i = 1; i < n; i++) {
            if (tmp[i]!=(tmp[i - 1])) {
                Num++;
            }
        }
        return Num;
    }
    //统计二维数组IP地址及其个数
    public static Long[] arraycount1(long[] a){
        //计算一维数组的长度
        int n= a.length;
        //将数组拷贝到新的地址，这样对新数组操作不会改变原数组
        long[] tmp = new long[n];
        System.arraycopy(a, 0, tmp, 0, n);
        //统计元素种类数
        //将数组按元素大小重新排序
        Arrays.sort(tmp);
        Long[] iphosts = new Long[n];
        tmp[n-1] = 100;
        int k = 0;
        Long count = 0L;
        for (int i = 0; i < n-1; i++) {
            count++;
            if (tmp[i] != tmp[i + 1]) {
                iphosts[k] = tmp[i];
                iphosts[k+1] = count;
                k = k+2;
                count = 0L;
            }
        }
        return iphosts;
    }
    //
    public int count(Long[] a){
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i]!=null){
                count++;
            }
        }
        return count;
    }
    //十进制转ip地址的方法
    public static String longToIp(long ip) {
        StringBuilder result = new StringBuilder(15);
        for (int i = 0; i < 4; i++) {
            result.insert(0,Long.toString(ip & 0xff));

            if (i < 3) {                result.insert(0,'.');
            }
            ip = ip >> 8;
        }
        return result.toString();
    }
    //map数组的比较方法
    public static ArrayList<Map.Entry<Long,Long>> sortMap(Map map){
        List<Map.Entry<Long, Long>> entries = new ArrayList<Map.Entry<Long, Long>>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Long, Long>>() {
            public int compare(Map.Entry<Long, Long> obj1 , Map.Entry<Long, Long> obj2) {
                return (int) (obj2.getValue() - obj1.getValue());
            }
        });
        return (ArrayList<Map.Entry<Long, Long>>) entries;
    }
}
