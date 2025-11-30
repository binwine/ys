package com.wine.ys.service.impl;


import com.wine.ys.mapper.StarwardMapper;
import com.wine.ys.model.entity.MonthlyStats;
import com.wine.ys.model.entity.TrendStats;
import com.wine.ys.model.entity.dto.DashboardData;
import com.wine.ys.model.entity.dto.StatRow;
import com.wine.ys.service.StarwardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;

/**
 * @ClassName: starwardServiceImpl
 * @Description:
 * @Author: binwine
 * @Date: 2025年11月30日 12:44
 */
@Service
public class StarwardServiceImpl implements StarwardService {

    @Resource
    private StarwardMapper starwardMapper;

    // 格式化器必须与 SQL 中的 STRFTIME 格式完全一致
    private static final DateTimeFormatter DAY_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM");

    @Override
    public List<MonthlyStats> getRawDataFromDb() {
        return starwardMapper.getRawDataFromDb();
    }

    @Override
    public List<MonthlyStats> getRawDailyDataFromDb() {
        return starwardMapper.getDailyTrendData();
    }

    public DashboardData calculateDashboardData() {
        DashboardData data = new DashboardData();

        // --- 1. 计算期望的日期/月份字符串 ---

        // 每日统计的日期字符串
        LocalDate today = LocalDate.now();
        String currentDay = today.format(DAY_FORMATTER);
        String previousDay = today.minusDays(1).format(DAY_FORMATTER);

        // 本月统计的月份字符串
        YearMonth thisMonth = YearMonth.now();
        String currentMonth = thisMonth.format(MONTH_FORMATTER);
        String previousMonth = thisMonth.minusMonths(1).format(MONTH_FORMATTER);


        // --- 2. 处理每日统计 ---
        List<StatRow> dailyRows = starwardMapper.getDailyDashbord();
        data.setDailyPrimogems(processStats(dailyRows, StatRow::getTotalPrimogems, currentDay, previousDay));
        data.setDailyMora(processStats(dailyRows, StatRow::getTotalMora, currentDay, previousDay));

        // --- 3. 处理本月统计 ---
        List<StatRow> monthlyRows = starwardMapper.getMonthlyDashbord();
        data.setMonthlyPrimogems(processStats(monthlyRows, StatRow::getTotalPrimogems, currentMonth, previousMonth));
        data.setMonthlyMora(processStats(monthlyRows, StatRow::getTotalMora, currentMonth, previousMonth));

        return data;
    }

    /**
     * 核心修正：通过匹配日期字符串来准确赋值 current 和 previous
     * * @param rows Mapper返回的结果集
     * @param valueExtractor 用于提取 Primogems 或 Mora 值的函数
     * @param currentPeriodStr 期望的当前周期字符串 (e.g., "2025-11-30")
     * @param previousPeriodStr 期望的上一周期字符串 (e.g., "2025-11-29")
     */
    private TrendStats processStats(List<StatRow> rows, Function<StatRow, Long> valueExtractor,
                                    String currentPeriodStr, String previousPeriodStr) {

        TrendStats stats = new TrendStats();

        // 默认值 (如果数据库没有返回任何数据，则为 0)
        long current = 0L;
        long previous = 0L;

        // 遍历所有结果行，根据日期匹配赋值
        if (rows != null) {
            for (StatRow row : rows) {
                if (row.getRecordPeriod().equals(currentPeriodStr)) {
                    // 匹配到当前周期
                    current = valueExtractor.apply(row);
                } else if (row.getRecordPeriod().equals(previousPeriodStr)) {
                    // 匹配到上一周期
                    previous = valueExtractor.apply(row);
                }
            }
        }

        stats.setCurrent(current);
        stats.setPrevious(previous);

        // --- 计算差异 (与之前逻辑保持一致) ---
        long diffAmount = current - previous;
        double diffPercent = 0.0;

        if (previous != 0) {
            diffPercent = ((double)diffAmount / previous) * 100;
        } else if (current != 0) {
            // 上期为 0，本期非 0
            diffPercent = current > 0 ? 100.0 : -100.0;
        }

        // 格式化输出
        stats.setDiffAmount(String.format("%+d", diffAmount));
        stats.setDiffPercent(String.format("%+.0f%%", diffPercent));

        return stats;
    }
}
