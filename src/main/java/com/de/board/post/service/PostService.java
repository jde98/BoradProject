package com.de.board.post.service;

import java.util.List;

import com.de.board.post.dto.AddPostDTO;
import com.de.board.post.dto.PostDTO;
import com.de.board.post.dto.UpdatePostDTO;

public interface PostService {
	
	List<PostDTO> getPostList(PostDTO postDTO);
	
	PostDTO getPost(int postId);
	
	int insertPost(AddPostDTO addPostDTO);
	
	int updatePost(UpdatePostDTO updatePostDTO);
	
	int deletePost(int postId);
}
