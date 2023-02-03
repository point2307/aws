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
@ToString(exclude = {"replyWriter" , "likey"})
public class Reply {
	@Id
	@GeneratedValue
	private	Long	reply_id;
	@OneToOne
	@JoinColumn(name = "writer")
	private Member	replyWriter;
	private	String	reply_content;
	
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private	Date regdate;
	
	@OneToMany
	@JoinColumn(name = "likey")
	private List<Member> likey;

}
