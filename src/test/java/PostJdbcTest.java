import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.specialist.java.spring.dao.AbstractDAO;
import ru.specialist.java.spring.config.JdbcConfig;
import ru.specialist.java.spring.dto.PostDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JdbcConfig.class)
@Sql(scripts = "classpath:sql_script/Microblog.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)

public class PostJdbcTest {

    private final DateTimeFormatter TIME_FORMAT =
            DateTimeFormatter.ofPattern("yyyy MM dd hh:mm:ss.SSS");

    private AbstractDAO<PostDto> postDAO;

    @Autowired
    public PostJdbcTest(AbstractDAO<PostDto> postDAO) {
        this.postDAO = postDAO;
    }

    @Test
    void create(){
        PostDto post = new PostDto();
        post.setTitle("Day 4");
        post.setContent("All is ok again");
        post.setCreatedAt(LocalDateTime.now());

        postDAO.create(post);

        assertEquals("Day 4", postDAO.getById(4).getTitle());

        Set<String> titles = postDAO.getAll().stream()
                .map(PostDto::getTitle)
                .collect(Collectors.toSet());

        assertEquals(Set.of("Day 1", "Day 2","Day 3","Day 4"), titles);
    }

    @Test
    void update(){
        PostDto post = postDAO.getById(1);
        post.setTitle("Day 5");
        LocalDateTime now = LocalDateTime.now();
        post.setUpdatedAt(now);
        postDAO.update(1, post);

        PostDto updatedPost = postDAO.getById(1);
        assertEquals("Day 5", updatedPost.getTitle());
        assertEquals(now.format(TIME_FORMAT),
                updatedPost.getUpdatedAt().format(TIME_FORMAT));


    }

    @Test
    void delete(){
        postDAO.delete(1);
        assertEquals(2, postDAO.getAll().size());
    }
}
