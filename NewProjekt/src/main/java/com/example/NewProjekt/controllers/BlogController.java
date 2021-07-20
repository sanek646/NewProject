package com.example.NewProjekt.controllers;

import com.example.NewProjekt.models.Post;
import com.example.NewProjekt.models.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {
    @Autowired
    private PostRepository postRepository;
    @GetMapping ("/blog")
    public String blogMain(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping ("/blog/new")
    public String blognew(Model model){
        return "blog-new";
    }
    @PostMapping("/blog/new")
    public String blogPostAdd(@RequestParam String first_name,@RequestParam String last_name,@RequestParam String annotation,Model model){
       Post post = new Post(first_name, last_name, annotation);
       postRepository.save(post);
        return "redirect:/blog";
    }
}
