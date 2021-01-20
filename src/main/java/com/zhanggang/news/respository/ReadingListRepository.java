package com.zhanggang.news.respository;

import com.zhanggang.news.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadingListRepository extends JpaRepository<Book,Long> {
    List<Book> findByReader(String reader);//根据读者名字查找阅读列表
}
