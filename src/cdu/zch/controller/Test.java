package cdu.zch.controller;

import com.google.gson.Gson;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        ArrayList<String> legendData = new ArrayList<String>();
        legendData.add("Email");
        legendData.add("Union Ads");
        legendData.add("Video Ads");
        legendData.add("Direct");
        legendData.add("Search Engine");

        // ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        ArrayList<String> xAxisData = new ArrayList<String>();
        xAxisData.add("Mon");
        xAxisData.add("Tue");
        xAxisData.add("Wed");
        xAxisData.add("Thu");
        xAxisData.add("Fri");
        xAxisData.add("Sat");
        xAxisData.add("Sun");

//        int[][] arr = new int[][]{{120, 132, 101, 134, 90, 230, 210},
//                {220, 182, 191, 234, 290, 330, 310},
//                {150, 232, 201, 154, 190, 330, 410},
//                {320, 332, 301, 334, 390, 330, 320},
//                {820, 932, 901, 934, 1290, 1330, 1320},
//        };
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(120);
        l1.add(132);
        l1.add(101);
        l1.add(134);
        l1.add(90);
        l1.add(230);
        l1.add(210);
        List<Integer> l2 = new ArrayList<>();
        l2.add(220);
        l2.add(182);
        l2.add(191);
        l2.add(234);
        l2.add(290);
        l2.add(330);
        l2.add(310);
        List<Integer> l3 = new ArrayList<>();
        l3.add(150);
        l3.add(232);
        l3.add(150);
        l3.add(201);
        l3.add(190);
        l3.add(330);
        l3.add(410);
        List<Integer> l4 = new ArrayList<>();
        l4.add(320);
        l4.add(332);
        l4.add(301);
        l4.add(334);
        l4.add(390);
        l4.add(330);
        l4.add(320);
        List<Integer> l5 = new ArrayList<>();
        l5.add(820);
        l5.add(932);
        l5.add(901);
        l5.add(934);
        l5.add(1290);
        l5.add(1330);
        l5.add(1320);
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        list.add(l5);
        Map<String, Object> json = new HashMap<>();
        json.put("legendData", legendData);
        json.put("xAxisData", xAxisData);
        json.put("series", list);

        String Json = new Gson().toJson(json);
    }
}
