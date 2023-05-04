package com.de.board.post.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.de.board.post.dto.AddPostDTO;
import com.de.board.post.dto.PostDTO;

@Mapper
public interface PostMapper {
	
	List<PostDTO> getPostList(PostDTO postDTO);
	
	PostDTO getPost(int postId);
	
	int insertPost(AddPostDTO addPostDTO);
	
	int updatePost(PostDTO postDTO);
	
	int deletePost(List<String> postIds);
}
