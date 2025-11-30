package com.wine.ys.service;



import com.wine.ys.model.entity.MonthlyStats;
import com.wine.ys.model.entity.dto.DashboardData;

import java.util.List;

public interface StarwardService {
    List<MonthlyStats> getRawDataFromDb();

    List<MonthlyStats> getRawDailyDataFromDb();

    DashboardData calculateDashboardData();

}
