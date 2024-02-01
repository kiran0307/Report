package com.Report.Report.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Report.Report.Model.DailyStoreReport;
import com.Report.Report.Model.StoreRest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsumingStoreService {

    @Autowired
    private DailyStoreReportService dailystorereportservice;

    private static final Logger log = LoggerFactory.getLogger(ConsumingStoreService.class);

    private final RestTemplate restTemplate;

    public ConsumingStoreService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void processStoreData() {
        try {
            StoreRest[] stores = restTemplate.getForObject("http://localhost:8080/store", StoreRest[].class);

            if (stores != null) {
                // Convert StoreRest to List<DailyStoreReport> and save it
                List<DailyStoreReport> dailyStoreReports = convertStoreToDailyReports(Arrays.asList(stores));
                dailystorereportservice.addDailyStoreReports(dailyStoreReports);

                Arrays.stream(stores).forEach(store -> {
                    log.info("Store Details: Stock ID: {}, Type ID: {}, Type Name: {}, Product ID: {},  Product Name: {}, " +
                                    "Product Price: {}, Product Quantity: {}, Invoice Number: {}, 	Invoice Id: {}, Cashier Id; {}, " +
                                    "Cashier Name:{}, Total Bill:{}",
                            store.stockId(), store.typeId(), store.typeName(), store.productId(),  store.productName(),
                            store.productIdPrice(), store.productQuantity(), store.invoiceNumber(),
                            store.invoiceId(), store.cashierId(),store.cashierName(), store.totalBill());
                });
            }
        } catch (Exception e) {
            log.error("Error processing store data: {}", e.getMessage(), e);
            // Handle the exception according to your application's requirements
        }
    }

    private List<DailyStoreReport> convertStoreToDailyReports(List<StoreRest> stores) {
        // Create a list of DailyStoreReport objects based on StoreRest data
        return stores.stream()
                .map(store -> new DailyStoreReport(store.invoiceId(), store.stockId(), store.typeId(),
                        store.typeName(), store.productId(), store.productName() , store.productIdPrice(), store.productQuantity(),
                        store.invoiceNumber(), store.cashierId(), store.cashierName(), store.totalBill()))
                .collect(Collectors.toList());
    }
}
