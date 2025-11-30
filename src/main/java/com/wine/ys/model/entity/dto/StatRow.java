package com.wine.ys.model.entity.dto;

public class StatRow {
    private String recordPeriod; // YYYY-MM-DD or YYYY-MM
    private Long totalPrimogems; // 对应 SQL 的 TotalPrimogems 别名
    private Long totalMora;      // 对应 SQL 的 TotalMora 别名

    // Getter and Setter (请自行生成)
    public String getRecordPeriod() { return recordPeriod; }
    public void setRecordPeriod(String recordPeriod) { this.recordPeriod = recordPeriod; }
    public Long getTotalPrimogems() { return totalPrimogems; }
    public void setTotalPrimogems(Long totalPrimogems) { this.totalPrimogems = totalPrimogems; }
    public Long getTotalMora() { return totalMora; }
    public void setTotalMora(Long totalMora) { this.totalMora = totalMora; }
}