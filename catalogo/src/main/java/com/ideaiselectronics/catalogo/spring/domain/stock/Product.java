package com.ideaiselectronics.catalogo.spring.domain.stock;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "PRODUTO")
public class Product {
	@Id
	@SequenceGenerator(name = "product_id", sequenceName = "product_id")
	@GeneratedValue(generator = "product_id", strategy = GenerationType.AUTO)
	@Column(name = "CD_PRODUCT")
	private Long id;

	@Column(name = "NM_NOME", nullable = false)
	private String name;

	@Column(name = "NM_DESCRICAO_LONGA", nullable = false)
	private String longDescription;

	@Column(name = "NM_DESCRICAO_CURTA", nullable = false)
	private String shortDescription;

	@Column(name = "NR_PESO", nullable = false)
	private Integer weight;

	@Column(name = "NR_GARANTIA", nullable = false)
	private Integer warranty;

	@Column(name = "NM_MARCA", nullable = false)
	private String brand;

	@Column(name = "NM_MODELO", nullable = false)
	private String model;
	
	@Column(name = "BO_ATIVO", nullable = false)
	private Boolean active;

	@ManyToOne
	@JoinColumn(name = "CD_SUBCATEGORIA", referencedColumnName = "CD_SUBCATEGORIA", nullable = false)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Subcategory subcategory;
	
	@ManyToOne
	@JoinColumn(name = "CD_CATEGORIA", referencedColumnName = "CD_CATEGORIA", nullable = false)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Category category;
	
	@OneToMany(mappedBy="product", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Item> items;

	@OneToOne
	@JoinColumn(name = "CD_DIMENSOES", referencedColumnName = "CD_DIMENSOES", nullable = false)
	@Cascade(CascadeType.ALL)
	private Dimensions dimensions;
	
	@Column(name = "NR_RANK")
	private Integer rank;
	
	@Transient
	private Item itemToDisplayOnShowcase;
	
	public List<Item> getItems() {
	    return items;
	}

	public void setItems(List<Item> items) {
	    this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Dimensions getDimensions() {
		return dimensions;
	}

	public void setDimensions(Dimensions dimensions) {
		this.dimensions = dimensions;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getWarranty() {
		return warranty;
	}

	public void setWarranty(Integer warranty) {
		this.warranty = warranty;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public Integer getRank() {
		return rank;
	}
	
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
	public Item getItemToDisplayOnShowcase() {
		if(this.itemToDisplayOnShowcase == null){
			this.itemToDisplayOnShowcase = getItemWithLowerPriceFor();
		}
		return this.itemToDisplayOnShowcase;
	}
	
	public Item getItemWithLowerPriceFor() {
		Item itemToCompare = items.get(0); //mudar pra set e tentar retornar o menor de uma maneira mais elegante
		for (Item item : items) {
			if( itemToCompare.isPriceForGreaterThan(item.getPriceFor()) ) {
				itemToCompare = item;
			}
		}
		return itemToCompare;
	}
	
}