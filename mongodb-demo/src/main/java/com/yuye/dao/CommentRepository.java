package com.yuye.dao;

import com.yuye.pojo.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Auther: yuye
 * @Date: 2022/2/28 - 02 - 28 - 14:30
 * @Description: com.yuye.dao
 * @version: 1.0
 */
@Repository
public interface CommentRepository extends MongoRepository<Comment,String> {
    Page<Comment> findByParentid(String parentid, Pageable pageable);
}
