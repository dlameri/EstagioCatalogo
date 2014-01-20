package com.ideaiseletronics.web.domain;

public class Dimensions {
	
	private Long id;
	private Double height;
	private Double width;
	private Double depth;
	
	public Dimensions() {
		
	}

	public Dimensions(Long id, Double height, Double width, Double depth) {
		this.id = id;
		this.height = height;
		this.width = width;
		this.depth = depth;
	}

}
