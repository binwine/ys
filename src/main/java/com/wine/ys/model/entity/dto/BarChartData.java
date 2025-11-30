package com.wine.ys.model.entity.dto;

import java.util.List;

public class BarChartData {
    // X轴数据：月份标签 (如 "25-08")
    private List<String> months;
    // Y轴数据 1：原石数量
    private List<Long> primogems;
    // Y轴数据 2：摩拉数量
    private List<Long> mora;

    // 请务必添加完整的 Getter/Setter 方法
    public List<String> getMonths() { return months; }
    public void setMonths(List<String> months) { this.months = months; }
    public List<Long> getPrimogems() { return primogems; }
    public void setPrimogems(List<Long> primogems) { this.primogems = primogems; }
    public List<Long> getMora() { return mora; }
    public void setMora(List<Long> mora) { this.mora = mora; }
}