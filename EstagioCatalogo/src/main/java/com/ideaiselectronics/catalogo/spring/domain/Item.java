package com.ideaiselectronics.catalogo.spring.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

public class Item {
	private Long id;
	private Long sku;
	private BigDecimal priceFrom;
	private BigDecimal priceFor;
	private String optionName;
	private String optionValue;
	private Integer stock;
	private Boolean active;
	private Integer rank;	
	private Product product;
	private List<Image> images;
	
	private int discount;
	private LinkedHashMap<Integer, BigDecimal> installments;
	private String formatedPriceFrom;
	private String formatedPriceFor;
	private Long productId;
	private String productName;
	private String urlImageMain;

	public List<Image> getImages() {
		if(images == null) {
			images = new ArrayList<Image>();
		}
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPriceFrom() {
		return priceFrom;
	}

	public void setPriceFrom(BigDecimal priceFrom) {
		this.priceFrom = priceFrom;
	}

	public BigDecimal getPriceFor() {
		return priceFor;
	}

	public void setPriceFor(BigDecimal priceFor) {
		this.priceFor = priceFor;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public Long getSku() {
		return sku;
	}

	public void setSku(Long sku) {
		this.sku = sku;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public Long getProductId() {
		return productId;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
	public Integer getRank() {
		return rank;
	}
	
	public int getDiscount() {
		discount = calculateDescount(getPriceFrom(), getPriceFor());
		return discount;
	}
	
	public void setFormatedPriceFrom(String formatedPriceFrom) {
		this.formatedPriceFrom = formatedPriceFrom;
	}
	
	public String getFormatedPriceFrom() {
		return formatedPriceFrom;
	}
	
	public void setFormatedPriceFor(String formatedPriceFor) {
		this.formatedPriceFor = formatedPriceFor;
	}
	
	public String getFormatedPriceFor() {
		return formatedPriceFor;
	}
	
	public LinkedHashMap<Integer, String> getInstallments() {
		return calculateInstallments(priceFor);
	}
		
	public int calculateDescount(BigDecimal priceFrom, BigDecimal priceFor) {
		double porcentagem = (((Double.valueOf(priceFor.doubleValue()) / Double.valueOf(priceFrom.doubleValue())) - 1) * 100) * -1;
		porcentagem = Double.valueOf(String.format(Locale.US, "%.0f", Math.floor(porcentagem)));
		return (int) porcentagem;
	}
	
	public LinkedHashMap<Integer, String> calculateInstallments(BigDecimal priceFor) {
		int parcela = 1;
		LinkedHashMap<Integer, String> parcelas = new LinkedHashMap<Integer, String>();
		double value = Double.valueOf(priceFor.doubleValue()) / parcela;
		
		do{
			parcelas.put(parcela, valueFormater(new BigDecimal(value).setScale(2, RoundingMode.HALF_EVEN)));
			parcela++;
			value = Double.valueOf(priceFor.doubleValue()) / parcela;
		} while(parcela <= 12 && value >= 10.00);
				
		return parcelas;
	}
			
	public String valueFormater(BigDecimal value) {
	    Locale Local = new Locale("pt", "BR");
	    DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(Local));
	    return df.format(value);
	}
	
	public String getUrlImageMain() {
		for (Image image : images) {
			if(image.getMain()){
				return image.getShowcaseUrl();
			}
		}
		return ""; //cria um NullObject para a imagem?
	}
	
	public boolean isPriceForGreaterThan(BigDecimal price) {
		return this.priceFor.compareTo(price) == 1;
	}

}