package com.todo.webservice.domain.Todo;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TODORepository extends JpaRepository<TODO, Long>{
	@Query("SELECT p "+""
			+ "FROM TODO p "
			+"ORDER BY p.id DESC")
	Stream<TODO> findAllDesc();
	
	@Transactional
	@Modifying
	@Query("UPDATE TODO p SET p.isDone = :isDone where p.id = :id")
	void updateTodo(@Param("id") Long id, @Param("isDone") String isDone);
	
	@Transactional
	@Query("SELECT p FROM TODO p WHERE p.isDone = '1' ORDER BY p.id ASC")
	Stream<TODO> findActive();
	
	@Transactional
	@Query("SELECT p FROM TODO p WHERE p.isDone = '0' ORDER BY p.id ASC")
	Stream<TODO> findDone();
}
