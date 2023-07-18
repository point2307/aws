package com.recipe.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Setter
@ToString(exclude = {"writer", "board", "recipe", "funding"})
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private	Long	replyId;
	@OneToOne
	@JoinColumn(name = "writer")
	@JsonIgnore
	private Member	writer;
	private	String	content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private	Date regdate;
	
	private int likeCount;

	@ManyToOne
	@JoinColumn(name = "boardId")
	@JsonIgnore
	private Board board;

	@ManyToOne
	@JoinColumn(name = "recipeId")
	@JsonIgnore
	private Recipe recipe;

	@ManyToOne
	@JoinColumn(name = "fundingId")
	@JsonIgnore
	private Funding funding;

	@PrePersist
	public void prePersist(){
		this.likeCount = 0;
	}
}
