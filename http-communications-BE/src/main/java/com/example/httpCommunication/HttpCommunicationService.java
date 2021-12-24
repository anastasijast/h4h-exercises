package com.example.httpCommunication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HttpCommunicationService {
    @Autowired
    private HttpCommunicationRepository repository;
    public List<User> getUsers(){
        return repository.getUsers();
    }
    public User getUserById(int id){
        return repository.getUserById(id);
    }
    public User updateEmail(int id,String email){ return repository.updateEmail(id,email); }
    public User createUser(User user){
        return repository.createUser(user);
    }
    public User updateUsername(int id,String username){ return repository.updateUsername(id,username);}
    public String deleteUser(int id){
        return  repository.deleteUser(id);
    }
    public User getUserByUsername(String username) {
        return repository.getUserByUsername(username);
    }
}
