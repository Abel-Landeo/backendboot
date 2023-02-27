package pe.example.backenddemo.service.impl;

import org.springframework.stereotype.Service;
import pe.example.backenddemo.controller.dto.UserRequest;
import pe.example.backenddemo.converter.UserMapper;
import pe.example.backenddemo.service.UserService;
import pe.example.backenddemo.service.model.User;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void save(UserRequest userRequest) {
        User user = userMapper.fromDtoToModel(userRequest);
        System.out.println(user);
    }
}
