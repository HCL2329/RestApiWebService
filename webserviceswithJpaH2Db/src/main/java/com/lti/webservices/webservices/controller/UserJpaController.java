package com.lti.webservices.webservices.controller;

import com.lti.webservices.webservices.exception.UserNotFoundException;
import com.lti.webservices.webservices.model.Post;
import com.lti.webservices.webservices.model.User;
import com.lti.webservices.webservices.repository.PostJpaRepository;
import com.lti.webservices.webservices.repository.UserJpaRepository;
import com.lti.webservices.webservices.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaController {
    @Autowired
    private UserDaoService userDaoService;
    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private PostJpaRepository postJpaRepository;

    @GetMapping("/Jpa/AllUser")
    public List<User> getAllUser() {
        return userJpaRepository.findAll();
    }


    //HATEOAS FrameWork  using here
    @GetMapping("/Jpa/AllUser/{id}")
    public EntityModel<User> getSingleUser(@PathVariable int id) {
        Optional<User> user = userJpaRepository.findById(id);
        if (user == null)
            throw new UserNotFoundException("User not exist with :" + id);

        EntityModel<User> model = EntityModel.of(user.get());
        WebMvcLinkBuilder linkToUser = linkTo(methodOn(this.getClass()).getAllUser());
        model.add(linkToUser.withRel("all-Users"));
        return model;
    }

    /*
    {

        "name": " Durgesh",
        "birthDate": "2022-02-03T11:06:44.532+00:00"
    }
     */
    @PostMapping("/Jpa/User")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User SavedUser = userJpaRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(SavedUser.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/Jpa/AllUser/{id}")
    public void deleteUser(@PathVariable int id) {
        userJpaRepository.deleteById(id);
        //   if(user==null)
        //     throw new UserNotFoundException("User not exist with :"+id);
    }

  /* @PutMapping("/AllUser")
    public List<User> updateUser(@RequestBody User user){
        return  userDaoService.updateUser(user);
    }*/

    @GetMapping("/Jpa/AllUser/{id}/posts")
    public List<Post> retrieveAllUsers(@PathVariable int id) {
        Optional<User> UserId = userJpaRepository.findById(id);
        if (UserId == null) {
            throw new UserNotFoundException("User not exist with :" + id);
        }
        return UserId.get().getPosts();

    }

    @PostMapping("/Jpa/User/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable int id, @Valid @RequestBody Post post) {

        Optional<User> UserId = userJpaRepository.findById(id);
        // if (!UserId.isPresent())
        if (UserId == null) {
            throw new UserNotFoundException("User not exist with :" + id);
        }
        User user = UserId.get();
        post.setUser(user);

        postJpaRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId()).toUri();

        return ResponseEntity.created(location).build();

    }


}
