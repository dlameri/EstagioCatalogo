package com.ideaiselectronics.catalogo.spring.domain.stock;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="CATEGORIA")
public class Category {
	@Id
	@SequenceGenerator(name="category_id", sequenceName="category_id")
	@GeneratedValue(generator="category_id", strategy=GenerationType.AUTO)
	@Column(name="CD_CATEGORIA")
	private Long id;
	
	@Column(name="NM_NOME", nullable=false, unique=true)
	private String name;
	
	@Column(name="BO_ATIVO", nullable=false)
	private Boolean active;
	
	@OneToMany(mappedBy="category", fetch = FetchType.EAGER, orphanRemoval=true)
	@Cascade({CascadeType.DELETE, CascadeType.SAVE_UPDATE})
	private List<Subcategory> subcategories;

	public List<Subcategory> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<Subcategory> subcategories) {
		this.subcategories = subcategories;
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
	
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public String toJson() {
		String json = "{" 
						+"\"id\": " + this.id + ","
						+"\"name\": " + "\"" + this.name + "\","
						+ "\"subcategories\": [";
						
		if(hasSubcategory()) {
			for (int i = 0; i < this.subcategories.size() ; i++) {
				Subcategory subcategory = subcategories.get(i);
				json = json.concat( subcategory.toJson() );
				if( i < subcategories.size()-1 ){
					json = json.concat(",");
				}
			}
		}
		return json.concat("]}");
	}
	
	public boolean hasSubcategory() {
		return this.subcategories != null && !this.subcategories.isEmpty();
	}
}
