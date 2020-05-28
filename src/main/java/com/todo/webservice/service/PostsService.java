package com.todo.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.webservice.domain.Todo.TODO;
import com.todo.webservice.domain.Todo.TODORepository;
import com.todo.webservice.dto.posts.PostsDeleteRequestDto;
import com.todo.webservice.dto.posts.PostsMainResponseDto;
import com.todo.webservice.dto.posts.PostsSaveRequestDto;
import com.todo.webservice.dto.posts.PostsUpdateRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
	private TODORepository todoRepository;

	// CREATE
	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		return todoRepository.save(dto.toEntity()).getId();
	}

	// READ(ALL)
	@Transactional
	public List<PostsMainResponseDto> findAllDesc() {
		return todoRepository.findAllDesc().map(PostsMainResponseDto::new).collect(Collectors.toList());
	}
	
	// READ(Action)
	@Transactional
	public List<PostsMainResponseDto> findActive() {
		return todoRepository.findActive().map(PostsMainResponseDto::new).collect(Collectors.toList());
	}
	
	// READ(Done)
	@Transactional
	public List<PostsMainResponseDto> findDone() {
		return todoRepository.findDone().map(PostsMainResponseDto::new).collect(Collectors.toList());
	}
	
	// UPDATE
	@Transactional
	public void updateTodo(PostsUpdateRequestDto dto) {
		todoRepository.updateTodo(dto.getId(), dto.getIsDone());
	}

	// DELETE
	@Transactional
	public void deleteTodo(PostsDeleteRequestDto dto) {
		todoRepository.deleteById(dto.getId());
		
	}

}
