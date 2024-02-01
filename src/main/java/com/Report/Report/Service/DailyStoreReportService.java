package com.Report.Report.Service;

import java.util.List;

import com.Report.Report.Model.DailyStockReport;
import com.Report.Report.Model.DailyStoreReport;

public interface DailyStoreReportService {
	
	  List<DailyStoreReport> getAllDailyStoreReports();

	  DailyStoreReport getDailyStoreReport(int reportId);

	  DailyStoreReport addDailyStoreReport(DailyStoreReport dailyStoreReport);

	  List<DailyStoreReport> addDailyStoreReports(List<DailyStoreReport> dailyreport);

	}

