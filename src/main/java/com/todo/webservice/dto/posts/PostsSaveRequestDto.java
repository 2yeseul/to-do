package com.todo.webservice.dto.posts;

import com.todo.webservice.domain.Todo.TODO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {
	private String title;
	private String isDone;
	private String img;
	
	@Builder
	public PostsSaveRequestDto(String title, String isDone, String img) {
		this.title = title;
		this.isDone = isDone;
		this.img = img;
	}
	
	public TODO toEntity() {
		return TODO.builder()
				.title(title)
				.isDone(isDone)
				.img(img)
				.build();
	}
}
