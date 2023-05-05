package com.de.board.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.de.board.common.ResponseDTO;
import com.de.board.post.dto.AddPostDTO;
import com.de.board.post.dto.PostDTO;
import com.de.board.post.dto.UpdatePostDTO;
import com.de.board.post.service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Tag(name = "Code", description = "코드 api")
@RestController
@RequestMapping("/post")
public class PostController {
	
	
	@Autowired
	private PostService postService;
	
	@Operation(summary = "포스트 리스트 조회")
	@GetMapping
	public ResponseEntity<ResponseDTO> getPostList(
			@RequestParam("title") String title,
			@RequestParam("createUser") String createUser
			) {
		PostDTO postDTO = new PostDTO();
		postDTO.setTitle(title);
		postDTO.setCreateUser(createUser);
		
		return ResponseEntity.ok(
				ResponseDTO.of(HttpStatus.OK, "getPostList Success", postService.getPostList(postDTO))
		);
	}
	
	@Operation(summary = "포스트 조회")
	@GetMapping("/{postId}")
	public ResponseEntity<ResponseDTO> getPost(
			@PathVariable("postId") int postId
			) {
		PostDTO postDTO = new PostDTO();
		postDTO.setPostId(postId);
		
		return ResponseEntity.ok(
				ResponseDTO.of(HttpStatus.OK, "getPost Success", postService.getPost(postDTO.getPostId()))
		);
	}
	
	@Operation(summary = "포스트 추가")
	@PostMapping
	public ResponseEntity<ResponseDTO> insertPost(@RequestBody AddPostDTO addPostDTO) {
		
		return ResponseEntity.ok(
				ResponseDTO.of(HttpStatus.OK, "insertPost Success", postService.insertPost(addPostDTO))
		);
	}
	
	@Operation(summary = "포스트 수정")
	@PutMapping
	public ResponseEntity<ResponseDTO> updatePost(@RequestBody UpdatePostDTO updatePostDTO) {
		
		return ResponseEntity.ok(
				ResponseDTO.of(HttpStatus.OK, "updatePost Success", postService.updatePost(updatePostDTO))
		);
	}
	
	@Operation(summary = "포스트 삭제")
	@DeleteMapping
	public ResponseEntity<ResponseDTO> deletePost(@RequestBody List<Integer> postIds) {
		
		return ResponseEntity.ok(
				ResponseDTO.of(HttpStatus.OK, "deletePost Success", postService.deletePost(postIds))
		);
	}
	
	
}
