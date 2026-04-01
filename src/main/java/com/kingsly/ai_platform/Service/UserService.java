package com.kingsly.ai_platform.Service;

import com.kingsly.ai_platform.Dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public UserDto createUser(UserDto userDto);
    public List<UserDto> getUser();
    public UserDto updateUser(long id,UserDto userDto);
    public String deleteUser(long id);

}
