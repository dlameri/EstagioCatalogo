package com.ideaiselectronics.catalogo.spring.domain.stock;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="SUBCATEGORIA")
public class Subcategory {
	@Id
	@SequenceGenerator(name="subcategory_id", sequenceName="subcategory_id")
	@GeneratedValue(generator="subcategory_id", strategy=GenerationType.AUTO)
	@Column(name="CD_SUBCATEGORIA")
	private Long id;
	
	@Column(name="NM_NOME", nullable=false)
	private String name;
	
	@Column(name="BO_ATIVO", nullable=false)
	private Boolean active;
	
	@ManyToOne
	@JoinColumn(name="CD_CATEGORIA", referencedColumnName="CD_CATEGORIA", nullable=false)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Category category;
	
	@OneToMany(mappedBy="subcategory", orphanRemoval=true)
	@Cascade({CascadeType.DELETE, CascadeType.SAVE_UPDATE})
	private List<Product> products;

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
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public String toJson() {
		return "{" 
					+"\"id\":" + this.id + ","
					+"\"name\":" + this.name
				+ "}";
	}
	
}
