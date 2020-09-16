package boo.web.voting.domain.posts;

import boo.web.voting.web.dto.PostSaveRequestDto;

public interface PostService {


     Long addPost(PostSaveRequestDto postSaveRequestDto);

     Posts findPostById(Long id);
}
