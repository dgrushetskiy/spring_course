package ru.specialist.java.spring.service;

public interface TagService {

    void createTag(String name);

    void createTags(String... names);
}
