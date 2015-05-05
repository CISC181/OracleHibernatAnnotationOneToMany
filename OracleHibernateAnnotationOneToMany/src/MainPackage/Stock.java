package MainPackage;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "stock", uniqueConstraints = {
		@UniqueConstraint(columnNames = "STOCK_NAME"),
		@UniqueConstraint(columnNames = "STOCK_CODE") })
public class Stock implements java.io.Serializable {
 

	private String CreatedBy;
	private Integer stockId;
	private String StockCode;
	private String stockName;
	private Set<StockDailyRecord> stockDailyRecords = new HashSet<StockDailyRecord>(
			0);
 
	public Stock() {
	}
 
	public Stock(String stockCode, String stockName) {
		this.StockCode = stockCode;
		this.stockName = stockName;
	}
 
	public Stock(String stockCode, String stockName,
			Set<StockDailyRecord> stockDailyRecords) {
		this.StockCode = stockCode;
		this.stockName = stockName;
		this.stockDailyRecords = stockDailyRecords;
	}
 

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STOCK")
	@SequenceGenerator(name = "SEQ_STOCK", sequenceName = "SEQ_STOCK", allocationSize = 1)
	@Column(name = "STOCK_ID")
	
	
	public Integer getStockId() {
		return this.stockId;
	}
 
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
 
 
 
	@Column(name = "STOCK_NAME", unique = true, nullable = false, length = 20)
	public String getStockName() {
		return this.stockName;
	}
 
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
 
	@Column(name = "Stock_Code",  nullable = true, length = 20)
	public String getStockCode() {
		return this.StockCode;
	}
 
	public void setStockCode(String StockCode) {
		this.StockCode = StockCode;
	}
	
	
	@Column(name = "CreatedBy",  nullable = true, length = 20)
	public String getCreatedBy() {
		return this.CreatedBy;
	}
 
	public void setCreatedBy(String CreatedBy) {
		this.CreatedBy = CreatedBy;
	}
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stock")
	public Set<StockDailyRecord> getStockDailyRecords() {
		return this.stockDailyRecords;
	}
 
	public void setStockDailyRecords(Set<StockDailyRecord> stockDailyRecords) {
		this.stockDailyRecords = stockDailyRecords;
	}
 
}