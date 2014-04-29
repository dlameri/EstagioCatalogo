package com.ideaiselectronics.catalogo.spring.domain.json;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.ideaiselectronics.catalogo.spring.domain.catalog.Installment;
import com.ideaiselectronics.catalogo.util.Formatter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemJSON {

	private Long id;
	private Long sku;
	private BigDecimal priceFrom;
	private BigDecimal priceFor;
	private String optionName;
	private String optionValue;
	private Integer stock;
	private Integer rank;
	private Boolean active;

	private String formattedPriceFrom;
	private String formattedPriceFor;
	private List<LinkJSON> links = new ArrayList<LinkJSON>();
	private Integer count;

	/* atributos usados para vizualizacao nos jsp - nao fazem parte do json */
	private List<ImageJSON> images;
	private ImageJSON imageMain;
	private Integer discount;
	private List<Installment> installments;

	private Installment lastInstallment;

	public ItemJSON() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSku() {
		return sku;
	}

	public void setSku(Long sku) {
		this.sku = sku;
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

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getFormattedPriceFrom() {
		return formattedPriceFrom;
	}

	public void setFormattedPriceFrom(String formattedPriceFrom) {
		this.formattedPriceFrom = formattedPriceFrom;
	}

	public String getFormattedPriceFor() {
		return formattedPriceFor;
	}

	public void setFormattedPriceFor(String formattedPriceFor) {
		this.formattedPriceFor = formattedPriceFor;
	}

	public List<LinkJSON> getLinks() {
		return links;
	}

	public void setLinks(List<LinkJSON> links) {
		this.links = links;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<ImageJSON> getImages() {
		return images;
	}

	public void setImages(List<ImageJSON> images) {
		this.images = images;
	}

	public ImageJSON getImageMain() {
		if (imageMain == null) {
			imageMain = getUrlImageMain();
		}
		return imageMain;
	}

	public Integer getDiscount() {
		if (discount == null) {
			discount = calculateDiscount(priceFrom, priceFor);
		}
		return discount;
	}

	public void setInstallments(BigDecimal priceFor) {
		if (priceFor == null) {
			setPriceFor(priceFor);
		}
		installments = calculateInstallments(priceFor);
	}

	public List<Installment> getInstallments() {
		if (installments == null) {
			setInstallments(priceFor);
		}
		return installments;
	}

	public Installment getLastInstallment() {
		if (lastInstallment == null) {
			lastInstallment = findLastInstallment(installments);
		}
		return lastInstallment;
	}

	public ImageJSON getUrlImageMain() {
		for (ImageJSON image : images) {
			if (image.getMain()) {
				return image;
			}
		}
		return new ImageJSON(); 
	}

	public boolean isPriceForGreaterThan(BigDecimal price) {
		return this.priceFor.compareTo(price) == 1;
	}

	public int calculateDiscount(BigDecimal priceFrom, BigDecimal priceFor) {
		double porcentagem = (((Double.valueOf(priceFor.doubleValue()) / Double
				.valueOf(priceFrom.doubleValue())) - 1) * 100) * -1;
		porcentagem = Double.valueOf(String.format(Locale.US, "%.0f",
				Math.floor(porcentagem)));
		return (int) porcentagem;
	}

	public List<Installment> calculateInstallments(BigDecimal priceFor) {
		int installment = 1;
		installments = new ArrayList<Installment>();
		double value = Double.valueOf(priceFor.doubleValue()) / installment;

		do {
			installments.add(new Installment(installment, Formatter
					.valueFormater(new BigDecimal(value).setScale(2,
							RoundingMode.HALF_EVEN))));

			installment++;
			value = Double.valueOf(priceFor.doubleValue()) / installment;
		} while (installment <= 12 && value >= 10.00);

		return installments;
	}

	public Installment findLastInstallment(List<Installment> installments) {
		if (lastInstallment == null) {
			if (this.installments == null) {
				this.installments = calculateInstallments(priceFor);
			}
			lastInstallment = installments.get(installments.size() - 1);
		}
		return lastInstallment;
	}

}
