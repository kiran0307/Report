package com.Report.Report.Dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Report.Report.Model.DailyStockReport;
//
public interface DailyReportDao extends JpaRepository <DailyStockReport, Integer> {
//
}
