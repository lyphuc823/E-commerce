package com.lyphuc.eCommerce.comment;

import com.lyphuc.eCommerce.comment.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> findAll();
    CommentDto findById(int id);
    void save(CommentDto comment);
    void deleteById(int id);
}
