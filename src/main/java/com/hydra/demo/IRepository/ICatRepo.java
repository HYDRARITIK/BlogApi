package com.hydra.demo.IRepository;


import com.hydra.demo.document.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICatRepo  extends JpaRepository<Category,Integer> {
}
