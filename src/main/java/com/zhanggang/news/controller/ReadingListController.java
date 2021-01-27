package com.zhanggang.news.controller;

import com.zhanggang.news.model.Book;
import com.zhanggang.news.respository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReadingListController {

    @Autowired
    private ReadingListRepository readingListRepository;

    @GetMapping("/{reader}")
    public String readerBooks(@PathVariable("reader") String reader, Model model){
        List<Book> list=readingListRepository.findByReader(reader);
        if (list!=null){
            model.addAttribute("books",list);
        }
        //System.out.println("dddd");
        return "readingList";
    }

    @PostMapping("/{reader}")
    public String addToReadingList(@PathVariable("reader") String reader,Book book) throws InterruptedException {
        book.setReader(reader);
        sleep60s();
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }

    public static void sleep60s() throws InterruptedException {
        for (int i=0;i<6;i++)
            Thread.sleep(1000);
    }
}
