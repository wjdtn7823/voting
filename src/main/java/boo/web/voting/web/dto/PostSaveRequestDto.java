package boo.web.voting.web.dto;

import boo.web.voting.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostSaveRequestDto(String title, String content, String author){
        this.title= title;
        this.content = content;
        this.author = author;

    }

    public Posts toPostEntity(){
        return Posts.builder().title(title).content(content).build();

    }


}