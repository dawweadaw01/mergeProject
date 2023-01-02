package cdu.zch.controller;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/testEcharts")
public class TestEchartsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        ArrayList<String> legendData = new ArrayList<String>();
        legendData.add("电视");
        legendData.add("电影");
        legendData.add("视频");
        legendData.add("海外");
        legendData.add("弹珠");

        ArrayList<String> xAxisData = new ArrayList<String>();
        xAxisData.add("2014");
        xAxisData.add("2015");
        xAxisData.add("2016");
        xAxisData.add("2017");
        xAxisData.add("2018");
        xAxisData.add("2019");
        xAxisData.add("2020");

//        int[][] arr = new int[][]{{120, 132, 101, 134, 90, 230, 210},
//                {220, 182, 191, 234, 290, 330, 310},
//                {150, 232, 201, 154, 190, 330, 410},
//                {320, 332, 301, 334, 390, 330, 320},
//                {820, 932, 901, 934, 1290, 1330, 1320},
//        };
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(96);
        l1.add(102);
        l1.add(111);
        l1.add(107);
        l1.add(105);
        l1.add(106);
        l1.add(113);
        List<Integer> l2 = new ArrayList<>();
        l2.add(41);
        l2.add(47);
        l2.add(42);
        l2.add(48);
        l2.add(66);
        l2.add(41);
        l2.add(43);
        List<Integer> l3 = new ArrayList<>();
        l3.add(106);
        l3.add(115);
        l3.add(102);
        l3.add(93);
        l3.add(79);
        l3.add(77);
        l3.add(59);
        List<Integer> l4 = new ArrayList<>();
        l4.add(241);
        l4.add(282);
        l4.add(326);
        l4.add(583);
        l4.add(767);
        l4.add(995);
        l4.add(1009);
        List<Integer> l5 = new ArrayList<>();
        l5.add(227);
        l5.add(242);
        l5.add(298);
        l5.add(294);
        l5.add(281);
        l5.add(269);
        l5.add(283);
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        list.add(l5);
        Map<String, Object> json1 = new HashMap<>();
        json1.put("legendData", legendData);
        json1.put("xAxisData", xAxisData);
        json1.put("seriesData", list);



        String Json = new Gson().toJson(json1);
        PrintWriter out = resp.getWriter();
        out.write(Json);
    }
}
