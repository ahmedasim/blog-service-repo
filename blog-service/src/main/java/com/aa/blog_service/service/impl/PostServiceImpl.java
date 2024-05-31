package com.aa.blog_service.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aa.blog_service.dto.PostRequestDto;
import com.aa.blog_service.dto.PostResponseDto;
import com.aa.blog_service.entity.Author;
import com.aa.blog_service.entity.Post;
import com.aa.blog_service.repo.PostRepo;
import com.aa.blog_service.service.AuthorService;
import com.aa.blog_service.service.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	PostRepo repo;
	
	@Autowired
	AuthorService authorService;
	
	@Autowired
	ObjectMapper objectMapper;

	
	@Override
	public PostResponseDto savePost(PostRequestDto dto) {
		Author author = authorService.findById(dto.getAuthorId());
		if(author == null) {
			throw new RuntimeException("Invalid author id!");
		}
		
		Post post = new Post();
		post.setText(dto.getText());
		post.setAuthor(author);
		repo.save(post);
		return getResponseDto(post);
	}

	private PostResponseDto getResponseDto(Post post) {
		PostResponseDto responseDto = objectMapper.convertValue(post, PostResponseDto.class);
		responseDto.setAuthorId(post.getAuthor().getAuthorId());
		return responseDto;
	}

	/*
	 * Method will only update the content of the post. Author of the post cannot be changed.
	 */
	@Override
	public PostResponseDto updatePost(PostRequestDto requestDto, Long postId) {
		Post post = findById(postId);
		post.setText(requestDto.getText());
		repo.save(post);
		return getResponseDto(post);
	}

	/*
	 * Method will not delete the post from database. It will mark the status deleted. Posts will be deleted from database when author is deleted
	 */
	@Override
	public void deletePost(Long postId) {
		Post post = findById(postId);
		post.setDeleted(true);
		repo.save(post);
	}

	@Override
	public PostResponseDto getPostById(Long postId) {
		Post post = findById(postId);
		return getResponseDto(post);
	}
	
	@Override
	public List<PostResponseDto> getPosts() {
		return repo.findAll().stream().map(post -> getResponseDto(post)).toList();
	}

	@Override
	public List<PostResponseDto> getPostsByAuthorId(Long authorId) {
		Author author = authorService.findById(authorId);
		return repo.findByAuthor(author).stream().map(post -> getResponseDto(post)).toList();
	}
	
	@Override
	public List<PostResponseDto> getAuthorPostsByAuthorIdAndDeleted(Long authorId, boolean isDeleted) {
		Author author = authorService.findById(authorId);
		return repo.findByAuthorAndIsDeleted(author, isDeleted).stream().map(post -> getResponseDto(post)).toList();
	}
	
	@Override
	public Post findById(Long postId) {
		Optional<Post> postOpt = repo.findById(postId);
		if(postOpt.isEmpty()) {
			throw new RuntimeException("Post not found!");
		}else {
			return postOpt.get();
		}
	}

}