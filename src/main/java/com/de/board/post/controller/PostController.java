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
import com.de.board.post.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	
	@Autowired
	private PostService postService;
	
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
	
	@PostMapping
	public ResponseEntity<ResponseDTO> insertPost(@RequestBody AddPostDTO addPostDTO) {
		
		return ResponseEntity.ok(
				ResponseDTO.of(HttpStatus.OK, "insertPost Success", postService.insertPost(addPostDTO))
		);
	}
	
	@PutMapping
	public ResponseEntity<ResponseDTO> updatePost(@RequestBody PostDTO postDTO) {
		
		return ResponseEntity.ok(
				ResponseDTO.of(HttpStatus.OK, "updatePost Success", postService.updatePost(postDTO))
		);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseDTO> deletePost(@RequestBody List<String> postIds) {
		
		return ResponseEntity.ok(
				ResponseDTO.of(HttpStatus.OK, "deletePost Success", postService.deletePost(postIds))
		);
	}
	
	
}
