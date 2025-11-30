package com.wine.ys.model.entity;

public class MonthlyStats {
    private Integer year;
    private Integer month;
    private Long currentPrimogems; // 原石
    private Long currentMora;// 摩拉
    private String time; //具体的时间
    // ... 其他字段可省略，MyBatis 只映射需要的字段

    // Getters and Setters
    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
    public Integer getMonth() { return month; }
    public void setMonth(Integer month) { this.month = month; }
    public Long getCurrentPrimogems() { return currentPrimogems; }
    public void setCurrentPrimogems(Long currentPrimogems) { this.currentPrimogems = currentPrimogems; }
    public Long getCurrentMora() { return currentMora; }
    public void setCurrentMora(Long currentMora) { this.currentMora = currentMora; }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}