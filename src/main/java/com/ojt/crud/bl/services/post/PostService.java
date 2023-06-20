package com.ojt.crud.bl.services.post;

import java.util.List;

import com.ojt.crud.bl.dto.PostDto;
import com.ojt.crud.persistence.entity.Post;
import com.ojt.crud.web.form.PostForm;

public interface PostService {
	List<PostDto> getAllPosts();
	
	List<PostDto> searchPosts(String search);
	void save(PostForm postForm);

    void deletePost(int id);

    void updatePost(PostForm postForm);
    
    PostDto getPostById(int id);
    
}
