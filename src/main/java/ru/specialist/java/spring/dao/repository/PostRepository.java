package ru.specialist.java.spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.specialist.java.spring.entity.Post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    Optional<Post> findByTitle(String title);

    List<Post> findByCreatedAtBetween(LocalDateTime from, LocalDateTime to);


    @Query(value = "select p.* from post p\n" +
            "\tjoin post_tag pt on p.post_id = pt.post_id\n" +
            "\tjoin tag t on (pt.tag_id = t.tag_id and lower(t.name) = lower(?))", nativeQuery = true)
    List<Post> findByTagName(String tagName);


//    1) Найти посты, содержащие в тексте(content) заданную подстроку (оператор like в SQL)
    List<Post> findByContentLikeIgnoreCase(String ssbstring);

//    TODO
//    2) Получить все посты, отсортированные по количеству тегов

    @Query(value = "select p.*\n" +
            "\tfrom post p\n" +
            "\t\tjoin post_tag pt\n" +
            "\t\t\ton p.post_id = pt.post_id\n" +
            "\tgroup by p.post_id\n" +
            "\torder by count(*) desc\n" +
            "\t\t\n", nativeQuery = true)
    List<Post> findSortedTagSorted();

}
