package com.yuye.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuye.controller.util.R;
import com.yuye.pojo.Book;
import com.yuye.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookControllerR {
    @Autowired
    private BookService bookService;
    @GetMapping
    public R getList(){
        return new R(true,bookService.list());
    }
    @PostMapping
    public R save(@RequestBody Book book){
        return new R(bookService.save(book));
    }
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,bookService.getById(id));
    }
    @DeleteMapping("{id}")
    public R deleteById(@PathVariable Integer id){
        return new R(bookService.removeById(id));
    }
    @PutMapping
    public R updateById(@RequestBody Book book){
        return new R(bookService.updateById(book));
    }
    @GetMapping("{pageCurrent}/{pageSize}")
    public R getPage(@PathVariable int pageCurrent,@PathVariable int pageSize){
        return new R(true,bookService.page(new Page(pageCurrent,pageSize)));
    }
//    @GetMapping
//    public List<Book> getByCondition(Book book){
//
//        return bookService.getByCondition(book);
//    }
}
