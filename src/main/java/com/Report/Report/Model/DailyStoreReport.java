package com.Report.Report.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DailyStoreReport {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int reportId;
	private int invoiceId;
	private int stockId;
	private int typeId;
	private String typeName;
	private int productId;
	private String productName;
	private double productIdPrice;
	private int productQuantity;
	private int invoiceNumber;
	private int cashierId;
	private String cashierName;
	private double totalBill;
	
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
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
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductIdPrice() {
		return productIdPrice;
	}
	public void setProductIdPrice(double productIdPrice) {
		this.productIdPrice = productIdPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public int getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public int getCashierId() {
		return cashierId;
	}
	public void setCashierId(int cashierId) {
		this.cashierId = cashierId;
	}
	public String getCashierName() {
		return cashierName;
	}
	public void setCashierName(String cashierName) {
		this.cashierName = cashierName;
	}
	public double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	
	public DailyStoreReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
//	public DailyStoreReport(int invoiceId, int stockId, int typeId, String typeName, int productId, String productName,
//			double productIdPrice, int productQuantity, int invoiceNumber, int cashierId, String cashierName,
//			int totalBill) {
//		super();
//		this.invoiceId = invoiceId;
//		this.stockId = stockId;
//		this.typeId = typeId;
//		this.typeName = typeName;
//		this.productId = productId;
//		this.productName = productName;
//		this.productIdPrice = productIdPrice;
//		this.productQuantity = productQuantity;
//		this.invoiceNumber = invoiceNumber;
//		this.cashierId = cashierId;
//		this.cashierName = cashierName;
//		this.totalBill = totalBill;
//	}
	
	
	public DailyStoreReport(int invoiceId, int stockId, int typeId, String typeName, int productId,
			String productName, double productIdPrice, int productQuantity, int invoiceNumber, int cashierId,
			String cashierName, double totalBill) {
		// TODO Auto-generated constructor stub
		
		super();
		this.invoiceId = invoiceId;
		this.stockId = stockId;
		this.typeId = typeId;
		this.typeName = typeName;
		this.productId = productId;
		this.productName = productName;
		this.productIdPrice = productIdPrice;
		this.productQuantity = productQuantity;
		this.invoiceNumber = invoiceNumber;
		this.cashierId = cashierId;
		this.cashierName = cashierName;
		this.totalBill = totalBill;
	}
	
	
	@Override
	public String toString() {
		return "DailyStoreReport [invoiceId=" + invoiceId + ", stockId=" + stockId + ", typeId=" + typeId
				+ ", typeName=" + typeName + ", productId=" + productId + ", productName=" + productName
				+ ", productIdPrice=" + productIdPrice + ", productQuantity=" + productQuantity + ", invoiceNumber="
				+ invoiceNumber + ", cashierId=" + cashierId + ", cashierName=" + cashierName + ", totalBill="
				+ totalBill + "]";
	}
	
	
	


}
