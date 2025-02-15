package com.concerto.devportal.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class UserDTO {
    private Long empId;
    private String name;
    private String email;
    private List<String> roles;

}
