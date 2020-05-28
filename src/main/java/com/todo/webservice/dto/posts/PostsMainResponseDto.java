package com.todo.webservice.dto.posts;

import com.todo.webservice.domain.Todo.TODO;

import lombok.Getter;

@Getter
public class PostsMainResponseDto {
	private Long id;
	private String title;
	private String isDone;
	private String img;
	
	public PostsMainResponseDto(TODO entity) {
		id = entity.getId();
		title = entity.getTitle();
		isDone = entity.getIsDone();
		img = entity.getImg();
	}
}
