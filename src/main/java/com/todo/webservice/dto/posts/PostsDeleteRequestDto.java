package com.todo.webservice.dto.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// 
@Getter
@Setter
@NoArgsConstructor
public class PostsDeleteRequestDto {
	private Long id;
	
	@Builder
	public PostsDeleteRequestDto(Long id) {
		this.id = id;
	}
}
