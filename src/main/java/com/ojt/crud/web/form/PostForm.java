package com.ojt.crud.web.form;



import javax.validation.constraints.NotBlank;

import com.ojt.crud.bl.dto.PostDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostForm {
	
	private int id;
	@NotBlank(message = "Please Enter Description")
	private String description;
	@NotBlank(message = "Please Enter Title")
	private String title;
	
	public PostForm(PostDto postDto) {
		this.id = postDto.getId();
		this.description = postDto.getDescription();
		this.title = postDto.getTitle();
	}
}
