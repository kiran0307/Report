package com.Report.Report.Service;

import java.util.List;

import com.Report.Report.Model.DailyStockReport;

public interface DailyStockReportService {
    List<DailyStockReport> getAllDailyReports();

    DailyStockReport getDailyReport(int reportId);

    DailyStockReport addDailyStockReport(DailyStockReport dailyreport);

    List<DailyStockReport> addDailyStockReports(List<DailyStockReport> dailyreport);
}
