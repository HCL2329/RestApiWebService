package com.lti.webservices.webservices.service;

import com.lti.webservices.webservices.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users=new ArrayList<>();
    private static int usersCount=4;
    static {

        users.add(new User(1, "Durgesh", new Date()));
        users.add(new User(2, "Shabnam", new Date()));

        users.add(new User(3, "samiksha", new Date()));

        users.add(new User(4, "Sham", new Date()));
    }

    //GET ALL USER
    public List<User> findAll(){
        return users;
    }
    //ADD NEW USER
    public  User save(User user){
        if(user.getId()==null)
        {
            user.setId(++usersCount);
        }
        users.add(user);
        return  user;
    }
    // Get Single User
    public  User findOne(int id){
        for(User user:users){
            if(user.getId()==id){
                return  user;
            }
        }
        return null;
    }


    // Delete User
    public  User deleteById(int id){
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if(user.getId()==id){
                iterator.remove();
                return  user;
            }
        }
        return null;
    }
    //Update User

    public List<User> updateUser(int id, User user){

        for(User user1:users){
            if(user1.getId()==id){
                user1.setId(user.getId());
                user1.setName(user.getName());
                user1.setBirthDate(user.getBirthDate());


                return  users;
            }

           /* //Update User

            public List<User> updateUser1(User user){

                for(User user1:users){
                    if(user1.getId()==user.getId()){
                        user1.setId(user.getId());
                        user1.setName(user.getName());
                        user1.setBirthDate(user.getBirthDate());


                        return  users;
                    }*/
        }
        return null;
    }
}
