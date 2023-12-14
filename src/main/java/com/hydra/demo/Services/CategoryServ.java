package com.hydra.demo.Services;

import com.hydra.demo.DTO.CategoryDto;
import com.hydra.demo.IRepository.ICatRepo;

import com.hydra.demo.document.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServ {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ICatRepo icatrepo;



    public CategoryDto createCategory(CategoryDto Categorydto){
        Category ToBeSaved=this.modelMapper.map(Categorydto,Category.class);
        Category savedCategory =icatrepo.save(ToBeSaved);
        CategoryDto Back=this.modelMapper.map(savedCategory, CategoryDto.class);
        return Back;
    }


    public List<CategoryDto> GetAllCategory(){
        List<Category> ui=icatrepo.findAll();
        List<CategoryDto> udt= ui.stream().map((curr_Category)->{
            return this.modelMapper.map(curr_Category, CategoryDto.class);
        }).toList();

        return udt;

    }
}
