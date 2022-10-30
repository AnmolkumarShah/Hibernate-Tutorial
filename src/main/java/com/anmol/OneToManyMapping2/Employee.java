package com.anmol.OneToManyMapping2;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@ToString(exclude = {"address"})
public class Employee {
	@Id
	int id;
	String name;
	double salary;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "emp")
	List<Address> address;
}
