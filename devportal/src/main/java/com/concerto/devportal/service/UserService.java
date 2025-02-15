package com.concerto.devportal.service;

import com.concerto.devportal.dto.UserDTO;
import com.concerto.devportal.entity.UserEntity;
import com.concerto.devportal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public Optional<UserDTO> getUserById(Long empId) {
        return userRepository.findById(empId).map(this::convertToDTO);
    }

    public Optional<UserDTO> getUserByEmail(String email) {
        return userRepository.findByEmail(email).map(this::convertToDTO);
    }

    public UserDTO saveUser(UserDTO userDTO) {
        UserEntity userEntity = convertToEntity(userDTO);
        UserEntity savedUser = userRepository.save(userEntity);
        return convertToDTO(savedUser);
    }

    public void deleteUser(Long empId) {
        userRepository.deleteById(empId);
    }

    // Convert UserEntity → UserDTO
    private UserDTO convertToDTO(UserEntity user) {
        UserDTO dto = new UserDTO();
        dto.setEmpId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRoles(user.getRoles().stream().map(role -> role.getName()).toList());
        return dto;
    }

    // Convert UserDTO → UserEntity
    private UserEntity convertToEntity(UserDTO dto) {
        UserEntity user = new UserEntity();
        user.setId(dto.getEmpId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }
}
