package com.ap.service;

import java.util.List;

import com.ap.binding.UserDto;

public interface UserService {
	
	public UserDto createUser(UserDto userDto);
	
	public UserDto updateUser(UserDto userDto,Integer userId);
	
	public List<UserDto> getAllUsers();
	
	public UserDto getUserById(Integer userId);
	
	public void deleteUser(Integer userId);

}
