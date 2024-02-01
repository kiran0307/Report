package com.Report.Report.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Report.Report.Model.DailyStoreReport;
import com.Report.Report.Service.DailyStoreReportService;

@RestController
@RequestMapping("/storereports")
public class DailyStoreReportController {

    @Autowired
    private DailyStoreReportService dailystorereportservice;

    @GetMapping
    public ResponseEntity<?> getAllDailyReports() {
        try {
            List<DailyStoreReport> dailyStoreReports = this.dailystorereportservice.getAllDailyStoreReports();
            return ResponseEntity.ok(dailyStoreReports);
        } catch (Exception e) {
            // Handle the exception according to your application's requirements
            return ResponseEntity.status(500).body("Error retrieving daily store reports: " + e.getMessage());
        }
    }

    @GetMapping("/{reportId}")
    public ResponseEntity<?> getDailyReport(@PathVariable String reportId) {
        try {
            DailyStoreReport dailyStoreReport = this.dailystorereportservice.getDailyStoreReport(Integer.parseInt(reportId));
            if (dailyStoreReport != null) {
                return ResponseEntity.ok(dailyStoreReport);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (NumberFormatException e) {
            // Handle the exception if the reportId is not a valid number
            return ResponseEntity.badRequest().body("Invalid reportId format: " + reportId);
        } catch (Exception e) {
            // Handle other exceptions
            return ResponseEntity.status(500).body("Error retrieving daily store report: " + e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addreportOrreports(@RequestBody List<DailyStoreReport> dailystorereport) {
        try {
            if (dailystorereport.isEmpty()) {
                return ResponseEntity.badRequest().body("Store report list cannot be empty");
            }

            if (dailystorereport.size() == 1) {
                DailyStoreReport addedReport = dailystorereportservice.addDailyStoreReport(dailystorereport.get(0));
                return ResponseEntity.ok(addedReport);
            } else {
                List<DailyStoreReport> addedReports = dailystorereportservice.addDailyStoreReports(dailystorereport);
                return ResponseEntity.ok(addedReports);
            }
        } catch (Exception e) {
            // Handle the exception according to your application's requirements
            return ResponseEntity.status(500).body("Error adding daily store report: " + e.getMessage());
        }
    }
}
