package com.ap.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ap.binding.UserDto;
import com.ap.entities.User;
import com.ap.repository.UserRepository;
import com.ap.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDto createUser(UserDto userDto) {

		User user = new User();
		BeanUtils.copyProperties(userDto, user);

		User savedUser = userRepository.save(user);

		UserDto userDto1 = new UserDto();
		BeanUtils.copyProperties(savedUser, userDto1);

		return userDto1;
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {

		Optional<User> findById = userRepository.findById(userId);
		if (findById.isPresent()) {
			User user = findById.get();
			BeanUtils.copyProperties(userDto, user);
			User savedUser = userRepository.save(user);

			UserDto saveduserDto = new UserDto();
			BeanUtils.copyProperties(savedUser, saveduserDto);

			return saveduserDto;
		}else {
			throw new RuntimeException("user not found");
		}

	}

	@Override
	public List<UserDto> getAllUsers() {
		return null;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		return null;
	}

	@Override
	public void deleteUser(Integer userId) {

	}

}
