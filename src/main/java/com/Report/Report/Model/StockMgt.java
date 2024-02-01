package com.Report.Report.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record StockMgt(int stockId, int typeId, int productId, String typeName, String productName, 
		int productPrice, int stockCountReceived, int currentStockCount) {
	

}
