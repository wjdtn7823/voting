package boo.web.voting.domain.posts;


import boo.web.voting.web.dto.PostSaveRequestDto;
import boo.web.voting.web.dto.PostUpdateRequestDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequiredArgsConstructor
public class PostController {

    PostService postService;

    @PostMapping("/posts/")
    ResponseEntity<Object> uploadPost(
           PostSaveRequestDto postSaveRequestDto
    ){

        long id =postService.addPost(postSaveRequestDto);
        Map <String, Object> map = new HashMap<>();
        map.put("postId",id);


        return new ResponseEntity(map,HttpStatus.OK);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody PostUpdateRequestDto postUpdateRequestDto){
        postService.update(id,postUpdateRequestDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Object> findPosById(@PathVariable Long id){
        Map <String, Object> map = new HashMap<>();

        Posts posts = postService.findPostById(id);
        map.put("post", posts);

        return new ResponseEntity(map,HttpStatus.OK);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Object> deletePostById(@PathVariable Long id){

    }


}
