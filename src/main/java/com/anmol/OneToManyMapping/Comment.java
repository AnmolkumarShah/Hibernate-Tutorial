package com.anmol.OneToManyMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int comment_id;
	String content;
	
	@ManyToOne()
	@JoinColumn(name = "hahah")
	Post post;
}
