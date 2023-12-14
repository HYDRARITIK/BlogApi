## 1)infinite recursion on one to many and many to one relation post ,user ,category 

#to solve in postDto use 
private CategoryDto category & private UserDto user

instead of

private Category category & private User user

beacuse dto(user,category) doesnot have reference to posts 


## 2)check content?type=application/json before sending data

