package com.ideaiselectronics.catalogo.spring.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="ITEM")
public class Item {
	@Id
	@SequenceGenerator(name="item_id", sequenceName="item_id")
	@GeneratedValue(generator="item_id", strategy=GenerationType.AUTO)
	@Column(name="CD_ITEM")
	private Long id;
	
	@Column(name="NR_SKU")
	private Long sku;
	
	@Column(name="NR_PRECO_DE", nullable=false)
	private BigDecimal priceFrom;
	
	@Column(name="NR_PRECO_POR", nullable=false)
	private BigDecimal priceFor;
	
	@Column(name="NM_NOME_OPCAO")
	private String optionName;
	
	@Column(name="NM_VALOR_OPCAO")
	private String optionValue;
	
	@Column(name="NR_ESTOQUE", nullable=false)
	private Integer stock;
	
	@Column(name="BO_ATIVO", nullable=false)
	private Boolean active;
	
	@Column(name="NM_RANK", nullable=false)
	private Integer rank;	
	
	@ManyToOne
	@JoinColumn(name="CD_PRODUCT", referencedColumnName="CD_PRODUCT", nullable=false)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Product product;
	
	@OneToMany(mappedBy="item", fetch = FetchType.EAGER)
	@Cascade({CascadeType.DELETE, CascadeType.SAVE_UPDATE})
	private List<Image> images;
	
	@Transient
	private int discount;
	
	@Transient
	private LinkedHashMap<Integer, BigDecimal> installments;
	
	@Transient
	private String formatedPriceFrom;

	@Transient
	private String formatedPriceFor;
	
	@Transient
	private Long productId;
	
	@Transient
	private String productName;
	
	@Transient
	private String urlImageMain;

	public List<Image> getImages() {
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
		return ""; //retornar uma url default caso o item não possua uma imagem principal;
	}
	
	public boolean isPriceForGreaterThan(BigDecimal price) {
		return this.priceFor.compareTo(price) == 1;
	}

	public String getFormatedPriceFrom() {
		return formatedPriceFrom;
	}

	public String getFormatedPriceFor() {
		return formatedPriceFor;
	}

}