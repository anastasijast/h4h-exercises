package com.example.httpCommunication;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HttpCommunicationRepository {
    List<User> users=new ArrayList<>();
    public List<User> getUsers(){
        return users;
    }
    public User getUserById(int id){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getId()==id){
                return users.get(i);
            }
        }
        return null;
    }
    public User updateEmail(int id,String email){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getId()==id){
                User user=users.get(i);
                user.setEmail(email);
                return user;
            }
        }
        return null;
    }
    public User createUser(User user){
        int id;
        if(users.isEmpty()){
            id=0;
        }
        else{
            id=users.get(users.size()-1).getId()+1;
        }
        User user_new=new User(id,user.getUsername(),user.getFirstName(),user.getLastName(),user.getEmail());
        users.add(user_new);
        return user_new;
    }
    public User updateUsername(int id,String username){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getId()==id){
                User user=users.get(i);
                user.setUsername(username);
                return user;
            }
        }
        return null;
    }
    public String deleteUser(int id){
        boolean p=false;
        try{
            for(int i=0;i<users.size();i++){
                if(users.get(i).getId()==id){
                    users.remove(users.get(i));
                    p=true;
                }
            }
            if(p){
                return ("User "+id+" has been deleted");
            }
            else{
                throw new Exception();
            }
        }
        catch (Exception e){
            return ("Error");
        }
    }
    public User getUserByUsername(String username){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getUsername().equals(username)){
                return users.get(i);
            }
        }
        return null;
    }
}
