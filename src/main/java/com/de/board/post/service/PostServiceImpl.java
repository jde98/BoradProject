package com.de.board.post.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.de.board.post.dto.AddPostDTO;
import com.de.board.post.dto.PostDTO;
import com.de.board.post.mapper.PostMapper;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostMapper postMapper;

	@Override
	public List<PostDTO> getPostList(PostDTO postDTO) {

		return postMapper.getPostList(postDTO);
	}

	@Override
	public PostDTO getPost(int postId) {

		return postMapper.getPost(postId);
	}

	@Override
	public int insertPost(AddPostDTO addPostDTO) {

		return postMapper.insertPost(addPostDTO);
	}

	@Override
	public int updatePost(PostDTO postDTO) {

		return postMapper.updatePost(postDTO);
	}

	@Override
	public int deletePost(List<String> postIds) {

		return postMapper.deletePost(postIds);
	}
	
}
