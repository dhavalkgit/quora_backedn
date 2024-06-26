package com.example.quora.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel{

    @Column(name = "userName", nullable = false, unique = true)
    private String email;

    private String name;

    @Column(length = 300)
    private String about;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> followers;

    @ManyToMany(mappedBy = "followers")
    private List<User> following;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Question> questions;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "user")
    private List<Answer> answers;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "user")
    private List<Comment> comments;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "user")
    private List<QuestionLike> questionLikes;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "user")
//    private List<AnswerLike> answerLikes;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "user")
    private List<CommentLike> commentLikes;


    public void addFollowers(User user){
        this.followers.add(user);
    }

    public void addFollowing (User user){
        this.following.add(user);
    }
}
