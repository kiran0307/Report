package com.Report.Report.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Report.Report.Model.DailyStockReport;
import com.Report.Report.Service.DailyStockReportService;

@RestController
@RequestMapping("/stockreports")
public class DailyReportController {

    @Autowired
    private DailyStockReportService dailyreportservice;

    @GetMapping
    public List<DailyStockReport> getAllDailyReports() {
        try {
            return this.dailyreportservice.getAllDailyReports();
        } catch (Exception e) {
            // Handle the exception according to your application's requirements
            return ResponseEntity.status(500).body("Error retrieving daily reports: " + e.getMessage());
        }
    }

    @GetMapping("/{reportId}")
    public ResponseEntity<?> getDailyReport(@PathVariable String reportId) {
        try {
            DailyStockReport dailyReport = this.dailyreportservice.getDailyReport(Integer.parseInt(reportId));
            if (dailyReport != null) {
                return ResponseEntity.ok(dailyReport);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid reportId format: " + reportId);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error retrieving daily report: " + e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStockOrStocks(@RequestBody List<DailyStockReport> dailystockreport) {
        try {
            if (dailystockreport.isEmpty()) {
                return ResponseEntity.badRequest().body("Stock list cannot be empty");
            }

            if (dailystockreport.size() == 1) {
                DailyStockReport addedStock = dailyreportservice.addDailyStockReport(dailystockreport.get(0));
                return ResponseEntity.ok(addedStock);
            } else {
                List<DailyStockReport> addedStocks = dailyreportservice.addDailyStockReports(dailystockreport);
                return ResponseEntity.ok(addedStocks);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error adding daily report: " + e.getMessage());
        }
    }
}
