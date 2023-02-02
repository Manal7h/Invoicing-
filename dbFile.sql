CREATE DATABASE Invoicing;


USE Invoicing;

SELECT * FROM CustomerTable;

SELECT * FROM ItemTable;

SELECT * FROM Shop;

SELECT * FROM InvoiceTable;

SELECT * FROM InvoiceHeader;

alter table CustomerTable DROP COLUMN Paid_Amount;

DROP TABLE ItemTable;

DROP TABLE InvoiceTable;

DROP TABLE InvoiceHeader;

DROP TABLE Shop;

SELECT Invoice_Id, Invoice_No,Invoice_Date,Total,Balance, 
JOIN CustomerTable ON CustomerTable.Customer_Id=InvoiceTable.Customer_Id;


SELECT Invoice_Id, Invoice_No,Invoice_Date,No_of_items,Total,Balance ,CustomerTable.Customer_Name
FROM InvoiceTable
INNER JOIN CustomerTable
ON InvoiceTable.Invoice_Id = CustomerTable.Customer_Id;



SELECT InvoiceTable.Invoice_Id, InvoiceTable.Invoice_No, InvoiceTable.Invoice_Date, InvoiceTable.Total, InvoiceTable.Balance, CustomerTable.CustomerName
FROM InvoiceTable
INNER JOIN CustomerTable ON InvoiceTable.Customer_Id = CustomerTable.Customer_Id;



SELECT InvoiceTable.Invoice_Id, InvoiceTable.Invoice_No, InvoiceTable.Invoice_Date, InvoiceTable.Total, InvoiceTable.Balance, CustomerTable.CustomerName
FROM (InvoiceTable
INNER JOIN CustomerTable ON InvoiceTable.Customer_Id = CustomerTable.CustomerID);



Select COUNT (*) AS Invoice_No ,(Select COUNT (*) from ItemTable) AS No_of_items , SUM (Total) AS Total  From InvoiceTable ;
SELECT * FROM CustomerTable;

SELECT * FROM ItemTable;

SELECT * FROM Shop;

SELECT * FROM InvoiceTable;

SELECT * FROM InvoiceHeader;