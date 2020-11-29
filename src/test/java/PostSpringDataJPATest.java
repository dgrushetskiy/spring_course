import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.specialist.java.spring.config.JpaConfig;
import ru.specialist.java.spring.dao.repository.PostRepository;
import ru.specialist.java.spring.entity.Post;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JpaConfig.class)
@Sql(scripts = "classpath:sql_script/Microblog.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Transactional
public class PostSpringDataJPATest {

    private final DateTimeFormatter TIME_FORMAT =
            DateTimeFormatter.ofPattern("yyyy MM dd hh:mm:ss.SSS");

    private PostRepository postRepository;

    @Autowired
    public PostSpringDataJPATest(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Test
    void create(){
        Post post = new Post();
        post.setTitle("Day 4");
        post.setContent("All is ok again");
        post.setCreatedAt(LocalDateTime.now());

        postRepository.save(post);

        assertEquals("Day 4", postRepository.findById(4L).get().getTitle());

        Set<String> titles = postRepository.findAll().stream()
                .map(Post::getTitle)
                .collect(Collectors.toSet());

        assertEquals(Set.of("Day 1", "Day 2","Day 3","Day 4"), titles);
    }

    @Test
    void update(){
        Post post = postRepository.findById(1L).get();
        post.setTitle("Day 5");
        LocalDateTime now = LocalDateTime.now();
        post.setUpdatedAt(now);
        postRepository.save(post);

        Post updatedPost = postRepository.findById(1L).get();
        assertEquals("Day 5", updatedPost.getTitle());
        assertEquals(now.format(TIME_FORMAT),
                updatedPost.getUpdatedAt().format(TIME_FORMAT));


    }

    @Test
    void delete(){
        postRepository.deleteById(1L);
        assertEquals(2, postRepository.findAll().size());
    }

    @Test
    void findByTitle(){
        assertEquals("It's all ok!",
                postRepository.findByTitle("Day 2").get().getContent());
    }

    @Test
    void findByCreatedAtBetween(){
        LocalDateTime from = LocalDateTime.now().minusDays(3);
        LocalDateTime to = LocalDateTime.now().minusDays(1);

        assertEquals(2, postRepository.findByCreatedAtBetween(from, to).size());
    }

    @Test
    void findByContentLikeIgnoreCase(){
        assertEquals(1, postRepository
                .findByContentLikeIgnoreCase("%all good%").size());
        assertEquals(1, postRepository
                .findByContentLikeIgnoreCase("%alL Good%").size());
    }

    @Test
    void findSortedByTagCount(){
        List<Long> ids = postRepository
                .findSortedTagSorted()
                .stream()
                .map(Post::getId)
                .collect(Collectors.toList());

        Assertions.assertIterableEquals(List.of(2L, 3L, 1L), ids);
    }

}
