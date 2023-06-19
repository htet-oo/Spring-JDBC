package com.ojt.crud.web.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.ojt.crud.bl.dto.PostDto;
import com.ojt.crud.bl.services.post.PostService;
import com.ojt.crud.web.form.PostForm;


@Controller
public class PostController {
	@Autowired
	private PostService postService;
	
	
	@RequestMapping("/posts/list")
	public ModelAndView getallPosts() {
		ModelAndView mv = new ModelAndView();
		List<PostDto> postDtoList = this.postService.getAllPosts();
		mv.addObject("posts", postDtoList);
		return mv;
	}
	
	@RequestMapping("/posts/create")
	public ModelAndView create() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("saveForm",new PostForm());
		return mv;
	}
	
	@RequestMapping(value = "/posts/create/save", method = RequestMethod.POST)
	public ModelAndView savePost(@ModelAttribute("saveForm") @Valid PostForm postForm,
			 					 BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("posts/create");
			return mv;
		}
		postService.save(postForm);
		mv.setViewName("redirect:/posts/list");
		return mv;
	}
	
	
	
	@RequestMapping("/posts/update")
	public ModelAndView update(@RequestParam int updateObjId) {
		ModelAndView mv = new ModelAndView();
		PostDto postDto = postService.getPostById(updateObjId);
		System.out.println(postDto.getDescription());
		mv.addObject("updateForm",new PostForm(postDto));
		return mv;
	}
	
	@RequestMapping(value = "/posts/edit", method = RequestMethod.POST)
	public ModelAndView editPost(@ModelAttribute("updateForm") @Valid PostForm postForm,
								BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("posts/update");
			return mv;
		}
		postService.updatePost(postForm);
		mv.setViewName("redirect:/posts/list");
		return mv;
	}
	
	
	
	@RequestMapping(value = "/posts/delete")
	public ModelAndView deletePost(@RequestParam int deleteId) {
		ModelAndView mv = new ModelAndView();
		postService.deletePost(deleteId);
		mv.setViewName("redirect:/posts/list");
		return mv;
	}


	

	
}
