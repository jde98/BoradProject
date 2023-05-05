package com.de.board.post.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.de.board.post.dto.AddPostDTO;
import com.de.board.post.dto.PostDTO;
import com.de.board.post.dto.UpdatePostDTO;

@Mapper
public interface PostMapper {
	
	List<PostDTO> getPostList(PostDTO postDTO);
	
	PostDTO getPost(int postId);
	
	int insertPost(AddPostDTO addPostDTO);
	
	int updatePost(UpdatePostDTO updatePostDTO);
	
	int deletePost(List<Integer> postIds);
}
