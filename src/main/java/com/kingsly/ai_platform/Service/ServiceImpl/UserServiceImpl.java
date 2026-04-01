package com.kingsly.ai_platform.Service.ServiceImpl;

import com.kingsly.ai_platform.Dto.UserDto;
import com.kingsly.ai_platform.Entity.UserEntity;
import com.kingsly.ai_platform.Exception.UserDetailsNotFoundException;
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

    @Override
    public UserDto updateUser(long id, UserDto userDto) {
        UserEntity user=userRepo.findById(id).orElseThrow(()->new UserDetailsNotFoundException("User Details not found for id "+id) );
        if (userDto.getName() != null) user.setName(userDto.getName());
        if (userDto.getEmail() != null) user.setEmail(userDto.getEmail());
        if (userDto.getPassword() != null) user.setPassword(userDto.getPassword());
        if (userDto.getRole() != null) user.setRole(userDto.getRole());

        UserEntity updatedEntity=userRepo.save(user);
        return modelMapper.map(updatedEntity, UserDto.class);
          }

    public String deleteUser(long id) {
        UserEntity user=userRepo.findById(id).orElseThrow(()->new UserDetailsNotFoundException("User Details not found for id "+id) );
        userRepo.delete(user);
        return "User Details Deleted";
    }

    public UserServiceImpl(UserRepo userRepo,ModelMapper modelMapper){
       this.userRepo=userRepo;
       this.modelMapper=modelMapper;
    }
}
