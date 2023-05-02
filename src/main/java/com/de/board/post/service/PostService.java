package com.de.board.post.service;

import java.util.List;

import com.de.board.post.dto.PostDTO;

public interface PostService {
	List<PostDTO> getPostList(PostDTO postDTO);
	
	PostDTO getPost(PostDTO postDTO);
	
	int insertPost(PostDTO postDTO);
	
	int updatePost(PostDTO postDTO);
	
	int deletePost(PostDTO postDTO);
}
