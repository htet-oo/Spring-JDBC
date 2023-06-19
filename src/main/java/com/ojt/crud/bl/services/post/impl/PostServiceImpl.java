package com.ojt.crud.bl.services.post.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ojt.crud.bl.dto.PostDto;
import com.ojt.crud.bl.services.post.PostService;
import com.ojt.crud.persistence.entity.Post;
import com.ojt.crud.web.form.PostForm;

@Service
@Transactional
public class PostServiceImpl implements PostService {
	
    static class UserMapper implements RowMapper<Post> {
        public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
            Post post = new Post();
            post.setId(rs.getInt("id"));
            post.setCreated_at(rs.getTimestamp("created_at"));
            post.setDescription(rs.getString("description"));
            post.setTitle(rs.getString("title"));
            return post;
        }
    }

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<PostDto> getAllPosts() {
		String sql = "select id, created_at, description, title from posts";
		var postObj = jdbcTemplate.query(sql, new UserMapper());
		return postObj.stream().map(obj -> new PostDto(obj)).toList();
	}
	
	@Override
	public void save(PostForm postForm) {
		String sql = "INSERT INTO posts (created_at, description, title) VALUES (?,?,?)";
		 jdbcTemplate.update(sql,LocalDateTime.now(),postForm.getDescription(), postForm.getTitle());
		
	}

	@Override
	public void deletePost(int id) {
		String sql = "DELETE FROM posts WHERE id = ?";
		jdbcTemplate.update(sql,id);
		
	}

	@Override
	public void updatePost(PostForm postForm) {
	    String sql = "UPDATE posts SET description = ?, title = ?, updated_at = ? WHERE id = ?";
		jdbcTemplate.update(sql,postForm.getDescription(),postForm.getTitle(),LocalDateTime.now(),postForm.getId());
		
	}

	@Override
	public PostDto getPostById(int id) {
		String sql = "SELECT * FROM posts WHERE id=?";
		@SuppressWarnings("deprecation")
		Post postData = jdbcTemplate.queryForObject(sql, new Object[] { id }, (rs, rowNum) -> {
			Post post = new Post();
			post.setId(rs.getInt("id"));
			post.setTitle(rs.getString("title"));
			post.setDescription(rs.getString("description"));
			post.setCreated_at(rs.getTimestamp("created_at"));
			return post;
		});
		
		return new PostDto(postData);
	}
}

