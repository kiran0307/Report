package com.Report.Report.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record StoreValue(int stockId,
int typeId,
String typeName,
int productId,
String productName,
double productIdPrice,
int productQuantity,
int invoiceNumber,
int invoiceId,
int cashierId,
String cashierName,
double totalBill) 
{
	

}
