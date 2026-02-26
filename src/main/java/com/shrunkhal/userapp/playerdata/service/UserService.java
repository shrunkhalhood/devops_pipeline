package com.shrunkhal.userapp.playerdata.service;

import java.util.List;
import com.shrunkhal.userapp.playerdata.model.User;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();
}