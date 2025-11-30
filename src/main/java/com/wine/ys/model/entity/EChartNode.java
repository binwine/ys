package com.wine.ys.model.entity;

import java.util.List;

// 专门用于 ECharts 树状结构的数据传输对象 (DTO)
public class EChartNode {
    private String name;
    private Long value; // 只有叶子节点（原石/摩拉）需要值
    private List<EChartNode> children;

    public EChartNode(String name) {
        this.name = name;
    }
    public EChartNode(String name, Long value) {
        this.name = name;
        this.value = value;
    }

    // Getters and Setters (MyBatis/Jackson 转换需要)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Long getValue() { return value; }
    public void setValue(Long value) { this.value = value; }
    public List<EChartNode> getChildren() { return children; }
    public void setChildren(List<EChartNode> children) { this.children = children; }
}