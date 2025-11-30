package com.wine.ys.mapper;

import com.wine.ys.model.entity.MonthlyStats;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: SampleTest
 * @Description:
 * @Author: binwine
 * @Date: 2025年11月30日 13:32
 */
@SpringBootTest
// ...
public class SampleTest {

    @Resource
    private StarwardMapper starwardMapper;

    @Test
    public void testDS() {
        System.out.println(starwardMapper.getRawDataFromDb());
    }
    @Test
    public void testDS1() {
        List<MonthlyStats> dailyTrendData = starwardMapper.getDailyTrendData();
        System.out.println("sss");
    }
}
