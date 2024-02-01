package com.Report.Report.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.Report.Report.Model.DailyStockReport;
import com.Report.Report.Model.StockMgt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsumingStockService {

    @Autowired
    private DailyStockReportService dailyReportService;

    private static final Logger log = LoggerFactory.getLogger(ConsumingStockService.class);

    private final RestTemplate restTemplate;

    public ConsumingStockService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void processStockData() {
        try {
            StockMgt[] stocks = restTemplate.getForObject("http://localhost:8081/stocks", StockMgt[].class);

            if (stocks != null) {
                // Convert StockMgt to List<DailyStockReport> and save it
                List<DailyStockReport> dailyStockReports = convertStockToDailyReports(Arrays.asList(stocks));
                dailyReportService.addDailyStockReports(dailyStockReports);

                Arrays.stream(stocks).forEach(stock -> {
                    log.info("Stock Details: Stock ID: {}, Type ID: {}, Product ID: {}, Type Name: {}, Product Name: {}, " +
                                    "Product Price: {}, Stock Count Received: {}, Current Stock Count: {}",
                            stock.stockId(), stock.typeId(), stock.productId(), stock.typeName(), stock.productName(),
                            stock.productPrice(), stock.stockCountReceived(), stock.currentStockCount());
                });
            }
        } catch (RestClientException e) {
            log.error("Error calling the stock service: {}", e.getMessage(), e);
        } catch (Exception e) {
            log.error("Error processing stock data: {}", e.getMessage(), e);

        }
    }

    private List<DailyStockReport> convertStockToDailyReports(List<StockMgt> stocks) {
        return stocks.stream()
                .map(stock -> new DailyStockReport(stock.stockId(), stock.typeId(), stock.productId(),
                        stock.currentStockCount(), stock.productPrice()))
                .collect(Collectors.toList());
    }
}
