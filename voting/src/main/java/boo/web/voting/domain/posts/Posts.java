package boo.web.voting.domain.posts;

import boo.web.voting.domain.BaseTimeEntity;
import boo.web.voting.domain.members.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne
    private Member author;

    @Builder
    public Posts(String title, String content, Member author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
