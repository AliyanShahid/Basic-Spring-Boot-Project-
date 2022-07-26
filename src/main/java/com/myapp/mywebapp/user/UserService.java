package com.myapp.mywebapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private userRepository repo;

    public List<user> listall() {
        return (List<user>) repo.findAll();
    }

    public void save(user user) {
        repo.save(user);
    }

    public user get(Integer id) throws UserNotFoundException {
        Optional<user> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("User Not Found with ID : " + id);

    }

    public void delete(Integer id) throws UserNotFoundException {
        Optional<user> re = repo.findById(id);
        if (re.isPresent()) {
            repo.deleteById(id);
        } else {
            throw new UserNotFoundException("User Not Found with ID : " + id);
        }
    }
}