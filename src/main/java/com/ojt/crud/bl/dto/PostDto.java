package com.ojt.crud.bl.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.ojt.crud.persistence.entity.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
	private int id;
	private String title;
	private String description;
	private Timestamp created_at;
	
	public PostDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.description = post.getDescription();
        this.created_at = post.getCreated_at();
        
	}
}
