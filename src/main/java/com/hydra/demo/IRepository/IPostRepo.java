package com.hydra.demo.IRepository;

import com.hydra.demo.document.Post;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface IPostRepo extends JpaRepository<Post,Integer>  {


//    @Query(value = "SELECT * FROM post WHERE MATCH(content, title) "
//            + "AGAINST (?1)", nativeQuery = true)
//    public Page<Post> search(String keyword, Pageable pageable);

}
