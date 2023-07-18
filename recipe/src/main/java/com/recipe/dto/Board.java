package com.recipe.dto;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Setter
@ToString(exclude = {"board_recipe", "board_mealkit", "replyList"})
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "board_seq")
	private	Long 	boardId;
	
	@ManyToOne
	@JoinColumn(name = "writer")
	private	Member	writer;
	private	String	category;
	private	String	title;
	private	String	content;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(updatable = false)
	private	Date	boardRegedit;
	private	String	boardImage;  // 후기에만 사용 가능
	private	int 	likedCount;
	private	int	    boardAlert;
	private int boardCnt;  // 조회수
	@ManyToOne
	@JoinColumn(name = "after_recipe")
	private Recipe recipe;
	@ManyToOne
	@JoinColumn(name = "after_kit")
	private Mealkit mealkit;
	@OneToMany(mappedBy = "board")
	private List<Reply> replyList;

	@PrePersist
	public void prePersist(){
		boardAlert = 0;
		likedCount = 0;
		boardCnt = 0;
	}

}
