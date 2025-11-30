package com.wine.ys.model.entity;

public class TrendStats {
    private long current;      // 本期（本月或今日）值
    private long previous;     // 上期（上月或昨日）值
    private String diffAmount; // 差额 (如 -178, -297)
    private String diffPercent; // 百分比变化 (如 -100%, -3%)
    
    // 省略 Getter/Setter

    public long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }

    public long getPrevious() {
        return previous;
    }

    public void setPrevious(long previous) {
        this.previous = previous;
    }

    public String getDiffAmount() {
        return diffAmount;
    }

    public void setDiffAmount(String diffAmount) {
        this.diffAmount = diffAmount;
    }

    public String getDiffPercent() {
        return diffPercent;
    }

    public void setDiffPercent(String diffPercent) {
        this.diffPercent = diffPercent;
    }
}