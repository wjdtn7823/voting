package boo.web.voting.domain.posts;

import boo.web.voting.domain.members.Member;
import boo.web.voting.domain.members.MemberRepository;
import boo.web.voting.web.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService{

    PostRepository postRepository;
    MemberRepository memberRepository;

    @Override
    public void addPost(PostSaveRequestDto postSaveRequestDto) {
        String user_name = postSaveRequestDto.getAuthor();

        Member member = memberRepository.findByEmail(user_name).orElseThrow(NoSuchElementException::new);

        Posts post = postSaveRequestDto.toPostEntity();

        postRepository.save(post);

    }
}
