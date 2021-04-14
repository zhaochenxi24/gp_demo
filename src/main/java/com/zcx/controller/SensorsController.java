package com.zcx.controller;

import com.zcx.entity.Event;
import com.zcx.service.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class SensorsController {

    @Autowired
    private SensorsService sensorsService;



    @GetMapping("/Sensors/a")
    public String wlan2(Model model){
        //1.表数据
        List<Event> eventInfo_a = sensorsService.getEventInfo_a();
        model.addAttribute("eventList",eventInfo_a);
        //2.图一数据
        List<Event> events = sensorsService.getAllEvent1();
        String[] arr = new String[events.size()];
        int i=0;
        for (Event event : events) {
            arr[i] = event.getSig_name();
            i++;
        }
        HashMap<String, Integer> map = NumOfEle(arr);
        ArrayList<Map.Entry<Long, Integer>> entry1 = sortMap(map);
//

        model.addAttribute("k1",entry1.get(0).getKey());
        model.addAttribute("k2",entry1.get(1).getKey());
        model.addAttribute("k3",entry1.get(2).getKey());
        model.addAttribute("k4",entry1.get(3).getKey());
        model.addAttribute("k5",entry1.get(4).getKey());
        model.addAttribute("v1",entry1.get(0).getValue());
        model.addAttribute("v2",entry1.get(1).getValue());
        model.addAttribute("v3",entry1.get(2).getValue());
        model.addAttribute("v4",entry1.get(3).getValue());
        model.addAttribute("v5",entry1.get(4).getValue());


        return "Sensors_a";
    }
    @GetMapping("/Sensors/e")
    public String Ethernet(Model model){
        //1.表数据
        List<Event> eventInfo_e = sensorsService.getEventInfo_e();
        model.addAttribute("eventList",eventInfo_e);
        //2.图一数据
        List<Event> events = sensorsService.getAllEvent5();
        String[] arr = new String[events.size()];
        int i=0;
        for (Event event : events) {
            arr[i] = event.getSig_name();
            i++;
        }
        HashMap<String, Integer> map = NumOfEle(arr);
        ArrayList<Map.Entry<Long, Integer>> entry1 = sortMap(map);


        model.addAttribute("k1",entry1.get(0).getKey());
        model.addAttribute("k2",entry1.get(1).getKey());
        model.addAttribute("k3",entry1.get(2).getKey());
        model.addAttribute("k4",entry1.get(3).getKey());
        model.addAttribute("k5",entry1.get(4).getKey());
        model.addAttribute("v1",entry1.get(0).getValue());
        model.addAttribute("v2",entry1.get(1).getValue());
        model.addAttribute("v3",entry1.get(2).getValue());
        model.addAttribute("v4",entry1.get(3).getValue());
        model.addAttribute("v5",entry1.get(4).getValue());


        return "Sensors_e";
    }
    @GetMapping("/test")
    public String test(){
        return "test";
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

    //表二，统计不同告警以及对应的个数
    public  static  HashMap<String, Integer> NumOfEle(String arr[]){
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            Integer num = map.get(s);
            map.put(s, num == null ? 1 : num + 1);
        }

        return map;
    }
}
