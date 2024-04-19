package com.lyphuc.eCommerce.comment;

import com.lyphuc.eCommerce.product.Product;
import com.lyphuc.eCommerce.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int commentId;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "comment_text")
    private String commentText;
    @Column(name = "rating")
    private int rating;
    @Column(name = "comment_date")
    @CreationTimestamp
    private LocalDateTime commentDate;

    //////////////////////////////

    public Comment(String commentText, int rating, LocalDateTime commentDate) {
        this.commentText = commentText;
        this.rating = rating;
        this.commentDate = commentDate;
    }

}
