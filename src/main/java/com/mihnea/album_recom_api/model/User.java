package com.mihnea.album_recom_api.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    private String userProfilePictureUrl;

    @ManyToMany
    @JoinTable(
            name = "user_following",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "following_id")
    )
    private List<User> following = new ArrayList<>();
    @ManyToMany(mappedBy = "following")
    private List<User> followers = new ArrayList<>();


    @OneToMany(mappedBy = "reviewer", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "poster", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<FriendPost> myPostsToFriends = new ArrayList<>();

    @OneToMany(mappedBy ="user", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<FriendPost> friendPostsToMe = new ArrayList<>();

}
