package com.wine.ys.controller;


import com.wine.ys.model.entity.MonthlyStats;
import com.wine.ys.model.entity.dto.BarChartData;
import com.wine.ys.model.entity.dto.DashboardData;
import com.wine.ys.service.StarwardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RestController
public class ChartDataController {
    // 假设 getRawDataFromDb() 仍然能获取到您之前提供的四个月的原始数据

    @Resource
    private StarwardService starwardService; // 假设您已经定义了 ChartService

    /**
     * 每月的数据
    */
    @GetMapping("/api/monthly-trend")
    public BarChartData getMonthlyTrendData() {
        // 假设这里调用 Service/Mapper 获取排序后的原始数据
        List<MonthlyStats> rawData = starwardService.getRawDataFromDb();
        
        BarChartData chartData = new BarChartData();
        List<String> months = new ArrayList<>();
        List<Long> primogems = new ArrayList<>();
        List<Long> mora = new ArrayList<>();

        // 遍历原始数据，将数据分离到各自的列表中
        for (MonthlyStats stats : rawData) {
            // X轴标签格式: 25-08 (只取年份的后两位和月份)
            months.add(String.format("%d-%02d", stats.getYear() % 100, stats.getMonth()));
            
            primogems.add(stats.getCurrentPrimogems());
            mora.add(stats.getCurrentMora());
        }

        chartData.setMonths(months);
        chartData.setPrimogems(primogems);
        chartData.setMora(mora);
        return chartData;
    }
    @GetMapping("/api/daily-trend")
    public BarChartData getDailyTrendData() {
        List<MonthlyStats> rawData = starwardService.getRawDailyDataFromDb();

        BarChartData chartData = new BarChartData();
        List<String> dates = new ArrayList<>();
        List<Long> primogems = new ArrayList<>();
        List<Long> mora = new ArrayList<>();

        // 遍历原始数据，填充列表
        for (MonthlyStats stats : rawData) {
            // X轴标签格式：11-01 (只取月-日)
            // 假设 stats.getDate() 返回的是 YYYY-MM-DD 格式
            String monthDay = stats.getTime().substring(5); // 取 MM-DD 部分
            dates.add(monthDay);
            primogems.add(stats.getCurrentPrimogems());
            mora.add(stats.getCurrentMora());
        }

        chartData.setMonths(dates); // 复用 months 字段存储 dates
        chartData.setPrimogems(primogems);
        chartData.setMora(mora);

        return chartData;
    }

    @GetMapping("/api/dashboard-data")
    public DashboardData getDashboardData() {
        return starwardService.calculateDashboardData();
    }

}