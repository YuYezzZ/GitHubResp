package com.yuye.controller;

import com.yuye.controller.util.R;
import com.yuye.pojo.Book;
import com.yuye.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
    public R save(@RequestBody Book book) throws IOException {
        if("123".equals(book.getName())) throw new IOException();
        boolean flag = bookService.save(book);
        return new R(flag,flag?"添加成功！":"添加失败！");
    }
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,bookService.getById(id),"编辑失败,重新同步数据！");
    }
    @DeleteMapping("{id}")
    public R deleteById(@PathVariable Integer id){
        boolean flag = bookService.removeById(id);
        return new R(flag,flag?"删除成功！":"删除失败,重新同步数据！");
    }
    @PutMapping
    public R updateById(@RequestBody Book book){
        boolean flag = bookService.updateById(book);
        return new R(flag,flag?"更新成功！":"更新失败！");
    }
//    分页查询
    /*@GetMapping("{pageCurrent}/{pageSize}")
    public R getPage(@PathVariable int pageCurrent,@PathVariable int pageSize){
        Page page = new Page(pageCurrent, pageSize);
        bookService.page(page);
        if(pageCurrent > page.getPages()) return new R(true,bookService.page(new Page(page.getPages(),pageSize)));
        return new R(true,page);
    }*/
//    条件查询分页查询整合
    @GetMapping("{pageCurrent}/{pageSize}")
    public R getPage(@PathVariable int pageCurrent,@PathVariable int pageSize,Book book){
        return new R(true,bookService.getPage(pageCurrent, pageSize, book));
    }
}
