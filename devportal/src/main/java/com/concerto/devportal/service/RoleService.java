package com.concerto.devportal.service;

import com.concerto.devportal.dto.RoleDTO;
import com.concerto.devportal.entity.RoleEntity;
import com.concerto.devportal.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public Optional<RoleDTO> getRoleById(Integer id) {
        return roleRepository.findById(id).map(this::convertToDTO);
    }

    public Optional<RoleDTO> getRoleByName(String name) {
        return roleRepository.findByName(name).map(this::convertToDTO);
    }

    public RoleDTO saveRole(RoleDTO roleDTO) {
        RoleEntity roleEntity = convertToEntity(roleDTO);
        RoleEntity savedRole = roleRepository.save(roleEntity);
        return convertToDTO(savedRole);
    }

    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
    }

    // Convert RoleEntity → RoleDTO
    private RoleDTO convertToDTO(RoleEntity role) {
        RoleDTO dto = new RoleDTO();
        dto.setId(role.getId());
        dto.setName(role.getName());
        return dto;
    }

    // Convert RoleDTO → RoleEntity
    private RoleEntity convertToEntity(RoleDTO dto) {
        RoleEntity role = new RoleEntity();
        role.setId(dto.getId());
        role.setName(dto.getName());
        return role;
    }
}
