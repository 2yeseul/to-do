package com.todo.webservice.web;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todo.webservice.domain.Todo.TODORepository;
import com.todo.webservice.dto.posts.PostsDeleteRequestDto;
import com.todo.webservice.dto.posts.PostsMainResponseDto;
import com.todo.webservice.dto.posts.PostsSaveRequestDto;
import com.todo.webservice.dto.posts.PostsUpdateRequestDto;
import com.todo.webservice.service.PostsService;
import com.todo.webservice.domain.Todo.TODO;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {
	private PostsService postsService;
	private TODORepository todoRepository;
	
	@PostMapping("/posts")
	public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
		return postsService.save(dto);
	}
	
	@PostMapping("/edit_test")
	public Long updateTodo(@RequestBody PostsSaveRequestDto dto, @RequestParam("id") Long id) {
		Optional<TODO> todoUpdate = todoRepository.findById(id);
		PostsSaveRequestDto update = new PostsSaveRequestDto();
		return postsService.save(update);
	}
	
	@PostMapping("/edit")
	public void update(@RequestBody PostsUpdateRequestDto dto) {
		System.out.println(dto.getId()+" "+dto.getIsDone());
		postsService.updateTodo(dto);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody PostsDeleteRequestDto dto) {
		postsService.deleteTodo(dto);
	}
}
