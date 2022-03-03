package com.yuye.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuye.mapper.BookMapper;
import com.yuye.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: yuye
 * @Date: 2022/3/3 - 03 - 03 - 17:20
 * @Description: com.yuye.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookMapper bookMapper;
    @GetMapping("/{page}/{size}")
    @ResponseBody
    public List<Book> findPage(@PathVariable("page")int page,@PathVariable("size")int size){
        PageHelper.startPage(page, size);
        List<Book> books = bookMapper.findAll();
        PageInfo<Book> bookPageInfo = new PageInfo<>(books);
        return bookPageInfo.getList();
    }
}
