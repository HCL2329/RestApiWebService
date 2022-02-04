package com.lti.webservices.webservices.controller;

import com.lti.webservices.webservices.exception.UserNotFoundException;
import com.lti.webservices.webservices.model.User;
import com.lti.webservices.webservices.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/AllUser")
    public List<User> getAllUser(){
        return  userDaoService.findAll();
    }

    @GetMapping("/AllUser/{id}")
    public User getSingleUser(@PathVariable int id){
        User user = userDaoService.findOne(id);
        if(user==null)
            throw new UserNotFoundException("User not exist with :"+id);
        return user;
    }
/*
{

    "name": " Durgesh",
    "birthDate": "2022-02-03T11:06:44.532+00:00"
}
 */
    @PostMapping("/User")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User SavedUser = userDaoService.save(user);

       URI location= ServletUriComponentsBuilder.fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(SavedUser.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/AllUser/{id}")
    public void deleteUser(@PathVariable int id){
        User user = userDaoService.deleteById(id);
        if(user==null)
            throw new UserNotFoundException("User not exist with :"+id);
    }

  /* @PutMapping("/AllUser")
    public List<User> updateUser(@RequestBody User user){
        return  userDaoService.updateUser(user);
    }*/


    /*
    {
        "id":2,
        "name": "Durgesh Gupta ",
        "birthDate": "2021-02-03T11:06:44.532+00:00"
    }
     */

    @PutMapping("/AllUser/{id}")
    public List<User> updateUserById(@PathVariable int id , @Valid @RequestBody User user){
       /* User userId = userDaoService.findOne(id);
        if(userId==null){
                throw new UserNotFoundException("User Not exist :"+id);}*/
        List<User> users = userDaoService.updateUser(id, user);
        return  users;
    }
}
