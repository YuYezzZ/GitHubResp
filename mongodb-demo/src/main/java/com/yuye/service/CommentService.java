package com.yuye.service;


import com.yuye.dao.CommentRepository;
import com.yuye.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yuye
 * @Date: 2022/2/28 - 02 - 28 - 11:29
 * @Description: com.yuye.service
 * @version: 1.0
 */
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存一个评论
     * @param comment
     */
    public void saveComment(Comment comment){
        //如果需要自定义主键，可以在这里指定主键；如果不指定主键，MongoDB会自动生成主键
        //设置一些默认初始值。。。
        //调用dao
        commentRepository.save(comment);
    }

    /**
     * 更新评论
     * @param comment
     */
    public void updateComment(Comment comment){
        //调用dao
        commentRepository.save(comment);
    }

    /**
     * 根据id删除评论
     * @param id
     */
    public void deleteCommentById(String id){
        //调用dao
        commentRepository.deleteById(id);
    }

    /**
     * 查询所有评论
     * @return
     */
    public List<Comment> findCommentList(){
        //调用dao
        return commentRepository.findAll();
    }

    /**
     * 根据id查询评论
     * @param id
     * @return
     */
    public Comment findCommentById(String id){
        //调用dao
        return commentRepository.findById(id).get();
    }
    /*
    * 分页查询
    */
    public Page<Comment> findCommentListByParentid(String parentid,int page,int size ){
        return  commentRepository.findByParentid(parentid, PageRequest.of(page-1,size));
    }
    /*
    * 点赞功能
    * */
    public void updateCommentLikenum(String id){
        Query query = Query.query(Criteria.where("_id").is(id));
        Update update = new Update();
        update.inc("likenum",1);
        mongoTemplate.updateFirst(query,update,"comment");
    }
}
