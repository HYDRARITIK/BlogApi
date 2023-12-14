package com.hydra.demo.Services;

import com.hydra.demo.DTO.PostDto;
import com.hydra.demo.DTO.PostDto;
import com.hydra.demo.DTO.UserDto;
import com.hydra.demo.Exception.ApplicationException;
import com.hydra.demo.IRepository.ICatRepo;
import com.hydra.demo.IRepository.IPostRepo;
import com.hydra.demo.IRepository.IUserRepo;
import com.hydra.demo.document.Category;
import com.hydra.demo.document.Post;
import com.hydra.demo.document.Post;
import com.hydra.demo.document.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServ {

//implement pagination,pazing,sorting using pageable object

//    createPost
    @Autowired
    private IPostRepo ipostRepo;

    @Autowired
    private ICatRepo iCatRepo;

    @Autowired
    private IUserRepo iUserRepo;
    @Autowired
    private ModelMapper modelMapper;


    public PostDto createPost(PostDto pdt,Integer userId,Integer categId){

        User u1=iUserRepo.findById(userId).orElseThrow(
                ()-> new ApplicationException("123","userNotFound",HttpStatus.NOT_FOUND)
        );

        Category c1=iCatRepo.findById(categId).orElseThrow(
                ()-> new ApplicationException("123","userNotFound",HttpStatus.NOT_FOUND)
        );



        Post ToBeSaved=modelMapper.map(pdt,Post.class);

        ToBeSaved.setUser(u1);
        ToBeSaved.setCategory(c1);

        Post saved=ipostRepo.save(ToBeSaved);
        
        return modelMapper.map(saved,PostDto.class);

    }

//    updatePost

    public PostDto updatePost( PostDto pdt,Integer postId){

        Post old=ipostRepo.findById(postId).orElseThrow(
                ()->new ApplicationException("11","PostNotFound", HttpStatus.NOT_FOUND)
        );
        
        old.setTitle(pdt.getTitle());
        old.setContent(pdt.getContent());
        
        Post saved=ipostRepo.save(old);
        
        return modelMapper.map(saved,PostDto.class);

    }


//    deletePost

    public void deletePost(Integer postId){

        Post old=ipostRepo.findById(postId).orElseThrow(
                ()->new ApplicationException("11","PostNotFound", HttpStatus.NOT_FOUND)
        );
        
        ipostRepo.delete(old);
        

    }

//    getAllPost

    public List<PostDto> getAllPost(Integer pageSize,Integer pageNo ,String sortby){

//        Pageable pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortby).ascending());

        List<Post> ui=ipostRepo.findAll().stream().toList();
        List<PostDto> udt= ui.stream().map((curr_post)->{
            return this.modelMapper.map(curr_post, PostDto.class);
        }).toList();

        return udt;

    }

//    getPostById


    public PostDto getPostById(Integer PostId){
        Post us=ipostRepo.findById(PostId).orElseThrow(
                ()->new ApplicationException("123","PostNotFOund",HttpStatus.NOT_FOUND));


        return this.modelMapper.map(us, PostDto.class);

    }



//    getPostsByCategory
public List<PostDto> getPostsByCategory(Integer categId){
    Category cat=iCatRepo.findById(categId).orElseThrow(
            ()->new ApplicationException("123","PostNotFOund",HttpStatus.NOT_FOUND));
    List<Post> Allposts=cat.getAllPosts();

    List<PostDto> posts=Allposts.stream().map(
            (curr_post)->{
                return modelMapper.map(curr_post,PostDto.class);
            }
    ).toList();

    return posts;

}



//    getPostByUser

    public List<PostDto> getPostsByUser(Integer userId){
        User us=iUserRepo.findById(userId).orElseThrow(
                ()->new ApplicationException("123","PostNotFOund",HttpStatus.NOT_FOUND));
        List<Post> Allposts=us.getAllPost();

        List<PostDto> posts=Allposts.stream().map(
                (curr_post)->{
                    return modelMapper.map(curr_post,PostDto.class);
                }
        ).toList();

        return posts;

    }


//    search post ByKeywords





}
