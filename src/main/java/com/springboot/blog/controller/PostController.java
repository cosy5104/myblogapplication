package com.springboot.blog.controller;

import com.springboot.blog.entity.Post;
import com.springboot.blog.payload.PostDto;
import com.springboot.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
        //create blog rest api
        @PostMapping
        public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
            return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
        }
        //get all posts
    @GetMapping
     public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
     }
     //get posts by id
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name="id") Long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }
    //update posts by id
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable (name="id") Long id){
        PostDto postResponse=postService.updatePost(postDto, id);
        return new ResponseEntity<>(postResponse,HttpStatus.OK);
    }
    //delete post api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name="id") Long id){
        postService.deletePostById(id);
        return  new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);

    }
    }

