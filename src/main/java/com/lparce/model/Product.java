package com.lparce.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
	private String type;
	private int discount;
	private BigDecimal amount;
	private Date date;
}