package com.Report.Report.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Report.Report.Model.DailyStockReport;
import com.Report.Report.Dao.DailyReportDao;
import com.Report.Report.Service.DailyStockReportService;

@Service
public class DailyStockReportImplement implements DailyStockReportService {
	
	@Autowired
	private DailyReportDao dailyreportdao;

	@Override
	public List<DailyStockReport> getAllDailyReports() {
		return dailyreportdao.findAll();
	}

	@Override
	public DailyStockReport getDailyReport(int stockId) {
		return dailyreportdao.findById(stockId).orElse(null);
	}

	@Override
	public DailyStockReport addDailyStockReport(DailyStockReport dailyreport) {
		return dailyreportdao.save(dailyreport);
	}

	@Override
	public List<DailyStockReport> addDailyStockReports(List<DailyStockReport> dailyreports) {
		return dailyreportdao.saveAll(dailyreports);
	}

}
