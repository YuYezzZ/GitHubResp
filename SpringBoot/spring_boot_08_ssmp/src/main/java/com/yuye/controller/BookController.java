package com.yuye.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuye.pojo.Book;
import com.yuye.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping
    public List<Book> getList(){
        return bookService.list();
    }
    @PostMapping
    public Boolean save(@RequestBody Book book){
        return bookService.save(book);
    }
    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id){
        return bookService.getById(id);
    }
    @DeleteMapping("{id}")
    public Boolean deleteById(@PathVariable Integer id){
        return bookService.removeById(id);
    }
    @PutMapping
    public Boolean updateById(@RequestBody Book book){
        return bookService.updateById(book);
    }
    @GetMapping("{pageCurrent}/{pageSize}")
    public Page<Book> getPage(@PathVariable int pageCurrent,@PathVariable int pageSize){
        return bookService.page(new Page(pageCurrent,pageSize));
    }
//    @GetMapping
//    public List<Book> getByCondition(Book book){
//
//        return bookService.getByCondition(book);
//    }
}
