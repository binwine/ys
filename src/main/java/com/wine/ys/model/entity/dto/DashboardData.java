package com.wine.ys.model.entity.dto;

import com.wine.ys.model.entity.TrendStats;

public class DashboardData {
    // 每日统计
    private TrendStats dailyPrimogems;
    private TrendStats dailyMora;

    // 本月统计
    private TrendStats monthlyPrimogems;
    private TrendStats monthlyMora;

    public TrendStats getDailyPrimogems() {
        return dailyPrimogems;
    }

    public void setDailyPrimogems(TrendStats dailyPrimogems) {
        this.dailyPrimogems = dailyPrimogems;
    }

    public TrendStats getDailyMora() {
        return dailyMora;
    }

    public void setDailyMora(TrendStats dailyMora) {
        this.dailyMora = dailyMora;
    }

    public TrendStats getMonthlyPrimogems() {
        return monthlyPrimogems;
    }

    public void setMonthlyPrimogems(TrendStats monthlyPrimogems) {
        this.monthlyPrimogems = monthlyPrimogems;
    }

    public TrendStats getMonthlyMora() {
        return monthlyMora;
    }

    public void setMonthlyMora(TrendStats monthlyMora) {
        this.monthlyMora = monthlyMora;
    }

    // 省略 Getter/Setter
}