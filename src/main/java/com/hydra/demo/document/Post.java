package com.hydra.demo.document;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.id.IdentityGenerator;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;

import java.io.Serializable;

@Entity
@Table(name="Post")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;


    private String imageName;

//  many post have 1 category
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="categoryFull")
     @JsonBackReference
    private Category category;

//    many post can be created by 1 user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userFull")
    @JsonBackReference
    private User user;


}
