package com.hydra.demo.document;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Category")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

//  1  cateogory -> many posts
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Post> AllPosts;

}
