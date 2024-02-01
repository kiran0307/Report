package com.Report.Report.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Report.Report.Dao.DailyStoreReportDao;
import com.Report.Report.Model.DailyStockReport;
import com.Report.Report.Model.DailyStoreReport;

@Service
public class DailyStoreReportImplement implements DailyStoreReportService {
	
	@Autowired
	private DailyStoreReportDao dailystorereportdao;

	@Override
	public List<DailyStoreReport> getAllDailyStoreReports() {
		// TODO Auto-generated method stub
		return dailystorereportdao.findAll();
	}

	@Override
	public DailyStoreReport getDailyStoreReport(int reportId) {
		return dailystorereportdao.findById(reportId).orElse(null);
	}

	@Override
	public DailyStoreReport addDailyStoreReport(DailyStoreReport dailyStoreReport) {
		return dailystorereportdao.save(dailyStoreReport);
	}

	@Override
	public List<DailyStoreReport> addDailyStoreReports(List<DailyStoreReport> dailyreport){
		return dailystorereportdao.saveAll(dailyreport);
	}

}
