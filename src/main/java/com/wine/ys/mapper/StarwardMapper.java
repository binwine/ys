package com.wine.ys.mapper;


import com.wine.ys.model.entity.MonthlyStats;
import com.wine.ys.model.entity.dto.StatRow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StarwardMapper {
    // 注意：这里没有继承 BaseMapper<Order>，因为我们只做自定义查询


/**
 * 从数据库获取原始数据的方法
 * 该方法用于查询并返回月度统计数据列表
 *
 * @return List<MonthlyStats> 包含月度统计数据的列表对象
 *         每个MonthlyStats对象代表一条月度统计数据记录
 */
    List<MonthlyStats> getRawDataFromDb();

/**
 * 获取每日趋势数据的方法
 *
 * @return 返回一个包含每月统计数据的列表，列表中的每个元素代表一个月的统计数据
 */
    List<MonthlyStats> getDailyTrendData();

/**
 * 获取每日仪表盘数据的方法
 *
 * @return 返回一个StatRow对象的列表，StatRow可能代表仪表盘中的一行数据或统计信息
 */
    List<StatRow> getDailyDashbord();

/**
 * 获取月度仪表盘数据的方法
 *
 * @return 返回一个包含StatRow对象的列表，StatRow可能代表仪表盘中的某一行数据
 *         每个StatRow对象可能包含与月度统计相关的各项指标信息
 */
    List<StatRow> getMonthlyDashbord();
}