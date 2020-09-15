package boo.web.voting.domain.posts;

import boo.web.voting.web.dto.PostSaveRequestDto;

public interface PostService {


     void addPost(PostSaveRequestDto postSaveRequestDto);

}
