package com.anmol.OneToOneMapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
	@Id
	int id;
	String path;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Temp_column")
	Employee emp;
}
