package dev.yoda.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("post")
public class PostRestController {
    private static final Logger logger = LoggerFactory.getLogger(PostRestController.class);
    private final PostService postService;

    public PostRestController(
            @Autowired PostService postService
    ) {
        this.postService = postService;
    }

    //http://localhost:8080/post
    //POST /post
    //REQUEST_BODY
    @PostMapping
    public void createPost(@RequestBody PostDto postDto) {
        logger.info(postDto.toString());
        this.postService.createPost(postDto);
    }

    //http://localhost:8080/post
    //GET /post
    @GetMapping
    public List<PostDto> readPostAll() {
        logger.info("in read post all");
        return this.postService.readPostAll();
    }

    //http://localhost:8080/post?id=0
    //GET /post/0
    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id) {
        logger.info("in read post");
        return this.postService.readPost(id);
    }

    //@PutMapping: 현재 보내는 데이터를 그 위치에 다시 넣어주세요.
    //@PostMapping: 새로운 것을 만들 때 사용.
    //PUT /post/0
    @PutMapping("{id}")
    public void updatePost(
            @PathVariable("id") int id,
            @RequestBody PostDto postDto
    ) {
        logger.info("target id: " + id);
        logger.info("update content: " + postDto);
        this.postService.updatePost(id, postDto);
    }

    //DELETE /post/0
    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id") int id) {
        this.postService.deletePost(id);
    }
}