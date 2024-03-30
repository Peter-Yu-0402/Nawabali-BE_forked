package com.nawabali.nawabali.domain;

import com.nawabali.nawabali.dto.CommentDto;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;


@Entity
//@Setter
@Getter
@Builder (toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "comment")
@Slf4j(topic = "CommentDomain 로그")
public class Comment {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 300)
    private String contents;

    @Column (updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn (name = "post_id")
    private Post post;

//    public void updateComment ( CommentDto.RequestDto dto) {
//        this.contents = dto.getContents();
//        this.modifiedAt = LocalDateTime.now();
//    }

}