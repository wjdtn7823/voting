package boo.web.voting.domain.posts;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/posts/add")
    ResponseEntity uploadPost(
            @RequestParam("title") String title,
            @RequestParam("content") String content
    ){

        postService.addPost(title,content);



        return new ResponseEntity(HttpStatus.OK);
    }

}
