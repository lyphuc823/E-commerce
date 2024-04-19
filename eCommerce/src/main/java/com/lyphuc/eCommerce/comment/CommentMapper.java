package com.lyphuc.eCommerce.comment;

import com.lyphuc.eCommerce.comment.CommentDto;
import com.lyphuc.eCommerce.comment.Comment;

import static com.lyphuc.eCommerce.product.ProductMapper.mapToProduct;
import static com.lyphuc.eCommerce.product.ProductMapper.mapToProductDto;
import static com.lyphuc.eCommerce.user.UserMapper.mapToUser;
import static com.lyphuc.eCommerce.user.UserMapper.mapToUserDto;

public class CommentMapper {
    public static CommentDto mapToCommentDto(Comment comment){
        CommentDto commentDto = CommentDto.builder()
                .commentId(comment.getCommentId())
                .rating(comment.getRating())
                .commentDate(comment.getCommentDate())
                .commentText(comment.getCommentText())
                .user(mapToUserDto(comment.getUser()))
                .build();
        return commentDto;
    }
    public static Comment mapToComment(CommentDto commentDto){
        Comment comment = Comment.builder()
                .commentId(commentDto.getCommentId())
                .rating(commentDto.getRating())
                .commentDate(commentDto.getCommentDate())
                .commentText(commentDto.getCommentText())
                .user(mapToUser(commentDto.getUser()))
                .build();
        return comment;
    }
}
