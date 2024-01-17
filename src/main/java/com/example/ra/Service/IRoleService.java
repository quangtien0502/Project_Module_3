package com.example.ra.Service;

import com.example.ra.model.entity.Role;

public interface IRoleService {
    Role findByRoleName(String roleName);
}
