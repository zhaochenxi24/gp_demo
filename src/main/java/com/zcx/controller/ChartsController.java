package com.zcx.controller;

import com.zcx.entity.Event;
import com.zcx.entity.IpHdr;
import com.zcx.entity.Sensor;
import com.zcx.service.ChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class ChartsController {

    @Autowired
    private ChartsService chartsService;

    @GetMapping("/charts")
    public String queryIpIpHdr (Model model) throws Exception {
        /**
         * 获取系统时间
         * time.substring(11, time.length())现在的小时
         * time.substring(10)现在的年月日
         */
        //表一数据————————————————————————————————————————————————————————————————————————————————————————————————————————
        Date today = new Date();
        SimpleDateFormat nyr=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time=nyr.format(today);
        List<Event> events = chartsService.queryEventfor24h();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int count7 = 0;
        int count8 = 0;
        int count9 = 0;
        int count10 = 0;
        int count11 = 0;
        int count12 = 0;
        int count13 = 0;
        int count14 = 0;
        int count15 = 0;
        int count16 = 0;
        int count17 = 0;
        int count18 = 0;
        int count19 = 0;
        for (int i = 0; i < events.size(); i++) {
            //当天
                if (hourMinuteBetween(events.get(i).getTimestamp().substring(11,16),"00:00","01:35")){
                    count1++;
                }else if (hourMinuteBetween(events.get(i).getTimestamp().substring(11,16),"01:36","02:30")){
                    count2++;
                }else if (hourMinuteBetween(events.get(i).getTimestamp().substring(11,16),"02:31","03:45")){
                    count3++;
                }else if (hourMinuteBetween(events.get(i).getTimestamp().substring(11,16),"03:46","05:00")){
                    count4++;
                }else if (hourMinuteBetween(events.get(i).getTimestamp().substring(11,16),"05:01","06:15")){
                    count5++;
                }else if (hourMinuteBetween(events.get(i).getTimestamp().substring(11,16),"06:16","07:30")){
                    count6++;
                }else if (hourMinuteBetween(events.get(i).getTimestamp().substring(11,16),"07:31","08:45")){
                    count7++;
                }else if (hourMinuteBetween(events.get(i).getTimestamp().substring(11,16),"08:46","10:00")){
                    count8++;
                }else if (hourMinuteBetween(events.get(i).getTimestamp().substring(11,16),"10:01","11:15")){
                    count9++;
                }else if (hourMinuteBetween(events.get(i).getTimestamp().substring(11,16),"11:16","12:30")){
                    count10++;
                }else if (hourMinuteBetween(events.get(i).getTimestamp().substring(11,16),"12:31","13:45")){
                    count11++;
                }else if (hourMinuteBetween(events.get(i).getTimestamp().substring(11,16),"13:46","15:00")){
                    count12++;
                }else if (hourMinuteBetween(events.get(i).getTimestamp().substring(11,16),"15:01","16:15")){
                    count13++;
                }else if (hourMinuteBetween(events.get(i).getTimestamp().substring(11,16),"16:16","17:30")){
                    count14++;
                }else if (hourMinuteBetween(events.get(i).getTimestamp().substring(11,16),"17:31","18:45")){
                    count15++;
                }else if (hourMinuteBetween(events.get(i).getTimestamp().substring(11,16),"18:46","20:00")){
                    count16++;
                }else if (hourMinuteBetween(events.get(i).getTimestamp().substring(11,16),"20:01","21:15")){
                    count17++;
                }else if (hourMinuteBetween(events.get(i).getTimestamp().substring(11,16),"21:16","22:30")){
                    count18++;
                }else if (hourMinuteBetween(events.get(i).getTimestamp().substring(11,16),"22:31","23:59")){
                    count19++;
                }

            }
        model.addAttribute("count1",count1);
        model.addAttribute("count2",count2);
        model.addAttribute("count3",count3);
        model.addAttribute("count4",count4);
        model.addAttribute("count5",count5);
        model.addAttribute("count6",count6);
        model.addAttribute("count7",count7);
        model.addAttribute("count8",count8);
        model.addAttribute("count9",count9);
        model.addAttribute("count10",count10);
        model.addAttribute("count11",count11);
        model.addAttribute("count12",count12);
        model.addAttribute("count13",count13);
        model.addAttribute("count14",count14);
        model.addAttribute("count15",count15);
        model.addAttribute("count16",count16);
        model.addAttribute("count17",count17);
        model.addAttribute("count18",count18);
        model.addAttribute("count19",count19);
        //表二数据————————————————————————————————————————————————————————————————————————————————————————————————————————
        List<Event> events2 = chartsService.queryEvetName();
//        for (int i = 0; i < events2.size(); i++) {
//            System.out.println(events2.get(i));
//        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = df.format(today);//fotmatDate今天
        Calendar c = Calendar.getInstance();

        c.setTime(today);
        c.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = c.getTime();//formatDate1昨天
        String formatDate1 = df.format(yesterday);

        c.setTime(today);
        c.add(Calendar.DAY_OF_MONTH, -2);
        Date before_yesterday = c.getTime();//formatDate2前天
        String formatDate2 = df.format(before_yesterday);

        //事件名称，日期，数量
        int q=0,w=0,e=0 ;
        for (Event event : events2) {
            if (event.getTimestamp().substring(0,10).equals(formatDate)){
                q++;
            }else if (event.getTimestamp().substring(0,10).equals(formatDate1)){
                w++;
            }else if (event.getTimestamp().substring(0,10).equals(formatDate2)){
                e++;
            }
        }
        String[] arr = new String[q];
        String[] arr1 = new String[w];
        String[] arr2 = new String[e];
        HashMap<String, Integer> map;
       q=0;w=0;e=0;
        for (Event event : events2) {
            if (event.getTimestamp().substring(0,10).equals(formatDate)){
                arr[q] = event.getSig_name();
                q++;
            }else if (event.getTimestamp().substring(0,10).equals(formatDate1)){
                arr1[e] = event.getSig_name();
                e++;
            }else if (event.getTimestamp().substring(0,10).equals(formatDate2)){
                arr2[w] = event.getSig_name();
               w++;
            }
        }
        HashMap<String, Integer> map1 = NumOfEle(arr);
        ArrayList<Map.Entry<Long, Integer>> entry1 = sortMap(map1);
        if(entry1.size()!=0){
        model.addAttribute("k1",entry1.get(0).getKey());
        model.addAttribute("k2",entry1.get(1).getKey());
        model.addAttribute("k3",entry1.get(2).getKey());
        model.addAttribute("v1",entry1.get(0).getValue());
        model.addAttribute("v2",entry1.get(1).getValue());
        model.addAttribute("v3",entry1.get(2).getValue());
        }else {
            model.addAttribute("k1",null);
            model.addAttribute("k2",null);
            model.addAttribute("k3",null);
            model.addAttribute("v1",0);
            model.addAttribute("v2",0);
            model.addAttribute("v3",0);
        }


        HashMap<String, Integer> map2 = NumOfEle(arr1);
        ArrayList<Map.Entry<Long, Integer>> entry2 = sortMap(map2);
        if(entry2.size()!=0){
        model.addAttribute("v4",entry2.get(0).getValue());
        model.addAttribute("v5",entry2.get(1).getValue());
        model.addAttribute("v6",entry2.get(2).getValue());
        }else {
            model.addAttribute("v4",0);
            model.addAttribute("v5",0);
            model.addAttribute("v6",0);
        }


        HashMap<String, Integer> map3 = NumOfEle(arr2);
        ArrayList<Map.Entry<Long, Integer>> entry3 = sortMap(map3);
        if(entry3.size()!=0){
        model.addAttribute("v7",entry3.get(0).getValue());
        model.addAttribute("v8",entry3.get(1).getValue());
        model.addAttribute("v9",entry3.get(2).getValue());
        }else {
            model.addAttribute("v7",0);
            model.addAttribute("v8",0);
            model.addAttribute("v9",0);
        }
        //表三数据————————————————————————————————————————————————————————————————————————————————————————————————————————
        Sensor sensor=null;
        HashMap<String, Integer> hashMap = new HashMap<>();
        List<Sensor> sensors = chartsService.queryCountHostname();
        for (int i = 0; i < sensors.size(); i++) {
            sensor = sensors.get(i);
            String hostname = sensor.getHostname();
            int last_cid = sensor.getLast_cid();
            if (hostname.equals("PLUVIOPHILE:{95E6E5E3-7B60-4944-829B-C2301DEBC9DA}")){
                hashMap.put("WLAN 2",sensors.get(i).getLast_cid());
            }else if   (sensors.get(i).getHostname().equals("PLUVIOPHILE:{4A8A40E4-9CCC-43ED-873C-FA8EDAB24DE5}")){
                hashMap.put("Vnet 8",sensors.get(i).getLast_cid());
            }else if   (sensors.get(i).getHostname().equals("PLUVIOPHILE:{E050CA78-47C0-4AB4-86E6-37DEE4BFE75A}")){
                hashMap.put("宽带连接",sensors.get(i).getLast_cid());
            }else if   (sensors.get(i).getHostname().equals("PLUVIOPHILE:{0B4C6077-2BD4-4A81-9344-6D6D5CC02627}")){
                hashMap.put("蓝牙连接",sensors.get(i).getLast_cid());
            }else if   (sensors.get(i).getHostname().equals("PLUVIOPHILE:{12D9AFAC-B892-41B6-A059-181C342B3F0B}")){
                hashMap.put("以太网",sensors.get(i).getLast_cid());}}
        ArrayList<Map.Entry<Long,Integer>> entries= sortMap(hashMap);

        model.addAttribute("host1",entries.get(0).getKey());
        model.addAttribute("host2",entries.get(1).getKey());
        model.addAttribute("host3",entries.get(2).getKey());
        model.addAttribute("host3",entries.get(3).getKey());


        model.addAttribute("hostcount1",entries.get(0).getValue());
        model.addAttribute("hostcount2",entries.get(1).getValue());
        model.addAttribute("hostcount3",entries.get(2).getValue());
        model.addAttribute("hostcount3",entries.get(3).getValue());
        //表四数据————————————————————————————————————————————————————————————————————

        //转了格式的当前时间formatDate
        Date today1 = new Date();//获取今天的日期
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = df1.format(today1);
        Calendar c1 = Calendar.getInstance();

        c1.setTime(today);
        c1.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday1 = c1.getTime();//这是昨天
        String format2 = df1.format(yesterday1);

        c1.setTime(today);
        c1.add(Calendar.DAY_OF_MONTH, -2);
        Date before_yesterday1 = c1.getTime();//这是前天
        String format3 = df1.format(before_yesterday1);


        int num1 = 0;
        int num2 = 0;
        int num3 = 0;

        for (int i = 0; i < events2.size(); i++) {
            if (events2.get(i).getTimestamp().substring(0, 10).equals(format1)){
                num1++;
            }else if(events2.get(i).getTimestamp().substring(0, 10).equals(format2)){
                num2++;
            }else if(events2.get(i).getTimestamp().substring(0, 10).equals(format3)){
                num3++;
            }
        }

        model.addAttribute("num1",num1);
        model.addAttribute("num2",num2);
        model.addAttribute("num3",num3);
        //表五数据————————————————————————————————————————————————————————————————————————————————————————————————————————

        List<Event> eventA = chartsService.queryAllEventA();
        String[] arrA = new String[eventA.size()];
        int x = 0;
        for (Event event : eventA) {
            arrA[x] = event.getSig_name();
            x++;
        }
        HashMap<String, Integer> hashMapA = NumOfEle(arrA);
        ArrayList<Map.Entry<Long, Integer>> entriesA = sortMap(hashMapA);
        model.addAttribute("A1",entriesA.get(0).getValue());
        model.addAttribute("A2",entriesA.get(1).getValue());
        model.addAttribute("A3",entriesA.get(2).getValue());
        model.addAttribute("k11",entriesA.get(0).getKey());
        model.addAttribute("k22",entriesA.get(1).getKey());
        model.addAttribute("k33",entriesA.get(2).getKey());

        List<Event> eventE = chartsService.queryAllEventE();
        String[] arrE= new String[eventE.size()];
        int y = 0;
        for (Event event : eventE) {
            arrE[y] = event.getSig_name();
            y++;
        }
        HashMap<String, Integer> hashMapE = NumOfEle(arrE);
        ArrayList<Map.Entry<Long, Integer>> entriesE = sortMap(hashMapE);
        model.addAttribute("B1",entriesE.get(0).getValue());
        model.addAttribute("B2",entriesE.get(1).getValue());
        model.addAttribute("B3",entriesE.get(2).getValue());
        //表六数据————————————————————————————————————————————————————————————————————————————————————————————————————————
        List<IpHdr> ipHdrs = chartsService.queryAllIp();
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
        HashMap<Long, Long> hashMap9 = new HashMap<>();
        for (int i = 0; i < iphosts.length; i+=2) {
            hashMap9.put(iphosts[i],iphosts[i+1]);
        }
        ArrayList<Map.Entry<Long, Long>> entryArrayList = sortMap1(hashMap9);
        model.addAttribute("i1",longToIp(entryArrayList.get(0).getKey()));
        model.addAttribute("i2",longToIp(entryArrayList.get(1).getKey()));
        model.addAttribute("i3",longToIp(entryArrayList.get(2).getKey()));

        model.addAttribute("n1",entryArrayList.get(0).getValue());
        model.addAttribute("n2",entryArrayList.get(1).getValue());
        model.addAttribute("n3",entryArrayList.get(2).getValue());
        return "charts";
    }



    //判断是否在一个时间段内的算法
    public static boolean hourMinuteBetween(String nowDate, String startDate, String endDate) throws Exception{

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        Date now = format.parse(nowDate);
        Date start = format.parse(startDate);
        Date end = format.parse(endDate);

        long nowTime = now.getTime();
        long startTime = start.getTime();
        long endTime = end.getTime();

        return nowTime >= startTime && nowTime <= endTime;
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
    //上附属方法
    public int count(Long[] a){
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i]!=null){
                count++;
            }
        }
        return count;
    }
    //map数组的比较方法
    public static ArrayList<Map.Entry<Long,Integer>> sortMap(Map map){
        List<Map.Entry<Long, Integer>> entries = new ArrayList<Map.Entry<Long, Integer>>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Long, Integer>>() {
            public int compare(Map.Entry<Long, Integer> obj1 , Map.Entry<Long, Integer> obj2) {
                return (int) (obj2.getValue() - obj1.getValue());
            }
        });
        return (ArrayList<Map.Entry<Long, Integer>>) entries;
    }
    public static ArrayList<Map.Entry<Long,Long>> sortMap1(Map map){
        List<Map.Entry<Long, Long>> entries = new ArrayList<Map.Entry<Long, Long>>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Long, Long>>() {
            public int compare(Map.Entry<Long, Long> obj1 , Map.Entry<Long, Long> obj2) {
                return (int) (obj2.getValue() - obj1.getValue());
            }
        });
        return (ArrayList<Map.Entry<Long, Long>>) entries;
    }

    //表二，统计不同告警以及对应的个数
    public  static  HashMap<String, Integer> NumOfEle(String arr[]){
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            Integer num = map.get(s);
            map.put(s, num == null ? 1 : num + 1);
        }

        return map;
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
}
