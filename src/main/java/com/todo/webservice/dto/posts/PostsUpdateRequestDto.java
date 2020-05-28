package com.todo.webservice.dto.posts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@NoArgsConstructor
public class PostsUpdateRequestDto {
	private String isDone;
	private Long id;
	
	@Builder
	public PostsUpdateRequestDto(Long id, String isDone) {
		this.id = id;
		this.isDone = isDone;
	}
	
}
