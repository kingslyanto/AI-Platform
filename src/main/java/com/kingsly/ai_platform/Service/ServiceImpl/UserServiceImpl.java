package com.kingsly.ai_platform.Service.ServiceImpl;

import com.kingsly.ai_platform.Dto.UserDto;
import com.kingsly.ai_platform.Entity.UserEntity;
import com.kingsly.ai_platform.Repository.UserRepo;
import com.kingsly.ai_platform.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private ModelMapper modelMapper;
    private UserRepo userRepo;
    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity user=modelMapper.map(userDto, UserEntity.class);
        UserDto savedUser=modelMapper.map(userRepo.save(user),UserDto.class);
        savedUser.setStatus("UserDetails Saved");
        return savedUser;
    }

    @Override
    public List<UserDto> getUser() {
        List<UserEntity> userList=userRepo.findAll();
        if(userList.isEmpty())
            throw new RuntimeException("User Details not found");
        List<UserDto> userDtoList=userList.stream().map(u->modelMapper.map(u,UserDto.class)).collect(Collectors.toList());
        return userDtoList;
    }

    public UserServiceImpl(UserRepo userRepo,ModelMapper modelMapper){
       this.userRepo=userRepo;
       this.modelMapper=modelMapper;
    }
}
