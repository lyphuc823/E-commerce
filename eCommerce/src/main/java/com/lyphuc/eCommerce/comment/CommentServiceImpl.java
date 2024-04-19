package com.lyphuc.eCommerce.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.lyphuc.eCommerce.comment.CommentMapper.mapToComment;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<CommentDto> findAll() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map(comment -> mapToCommentDto(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDto findById(int id) {
        Optional<Comment> result = commentRepository.findById(id);
        Comment comment = null;
        if(result.isPresent()){
            comment = result.get();
        }else{
            throw new RuntimeException("Did not find comment id: "+id);
        }
        return mapToCommentDto(comment);
    }

    @Override
    public void save(CommentDto commentDto) {
        Comment comment = mapToComment(commentDto);
        commentRepository.save(comment);
    }

    @Override
    public void deleteById(int id) {
        commentRepository.deleteById(id);
    }
    private CommentDto mapToCommentDto(Comment comment) {
        CommentDto commentDto = CommentDto.builder()
                .commentId(comment.getCommentId())
                .commentDate(comment.getCommentDate())
                .commentText(comment.getCommentText())
                .rating(comment.getRating())
                .build();
        return commentDto;
    }
}
