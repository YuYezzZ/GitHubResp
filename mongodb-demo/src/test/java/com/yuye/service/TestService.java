package com.yuye.service;

import com.yuye.pojo.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Auther: yuye
 * @Date: 2022/2/28 - 02 - 28 - 11:32
 * @Description: com.yuye.service
 * @version: 1.0
 */
@SpringBootTest
public class TestService {
    @Autowired
    private CommentService commentService;
    @Test
    //查询全部
    public void testFindList(){
        List<Comment> commentList = commentService.findCommentList();
        System.out.println(commentList);
    }
    @Test
    //单个查询
    public void testFindById(){
        Comment commentById = commentService.findCommentById("1");
        System.out.println(commentById);
    }
    @Test
    //添加数据
    public void testSaveComment(){
        Comment comment = new Comment();
        comment.setArticleid("100000");
        comment.setContent("测试添加数据");
        comment.setCreatedatetime(LocalDateTime.now());
        comment.setUserid("1003");
        comment.setNickname("凯撒大帝");
        comment.setState("1");
        commentService.saveComment(comment);
    }
    @Test
    //分页查询
    public void testFindByParentid(){
        Page<Comment> commentListByParentid = commentService.findCommentListByParentid("3",1,2);
        System.out.println(commentListByParentid.getTotalElements());
        System.out.println(commentListByParentid.getContent());
    }
    @Test
    //点赞
    public void testUpdateLikenum(){
        commentService.updateCommentLikenum("1");
    }
}
