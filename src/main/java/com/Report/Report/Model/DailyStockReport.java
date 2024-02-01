package com.Report.Report.Model;
//import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class DailyStockReport {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int reportId;
	private int stockId;
	private int typeId;
	private int productId;
	private int currentStockCount;
	private int productPrice;
	
	public int getReportID() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCurrentStockCount() {
		return currentStockCount;
	}
	public void setCurrentStockCount(int currentStockCount) {
		this.currentStockCount = currentStockCount;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	

	public DailyStockReport() {
		super();
	}
	
	public DailyStockReport(int stockId, int typeId, int productId, int currentStockCount, int productPrice) {
		super();
		//this.reportId = reportId;
		this.stockId = stockId;
		this.typeId = typeId;
		this.productId = productId;
		this.currentStockCount = currentStockCount;
		this.productPrice = productPrice;
	}
	
	
	@Override
	public String toString() {
		return "DailyReport [stockId=" + stockId + ", typeId=" + typeId + ", productId="
				+ productId + ", currentStockCount=" + currentStockCount + ", productPrice=" + productPrice	+ "]";
	}
	
				
}
