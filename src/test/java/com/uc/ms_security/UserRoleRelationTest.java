package com.uc.ms_security;

import com.uc.ms_security.entity.Role;
import com.uc.ms_security.entity.User;
import com.uc.ms_security.entity.UserRole;
import com.uc.ms_security.repository.RoleRepository;
import com.uc.ms_security.repository.UserRepository;
import com.uc.ms_security.repository.UserRoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserRoleRelationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Test
    void shouldPersistUserRoleAssignment() {
        User user = new User();
        user.setName("Ana");
        user.setEmail("ana-" + UUID.randomUUID() + "@test.com");
        user.setPassword("12345678");

        Role role = new Role();
        role.setName("ADMIN-" + UUID.randomUUID());
        role.setDescription("Administrador");

        userRepository.save(user);
        roleRepository.save(role);

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        UserRole saved = userRoleRepository.save(userRole);

        assertThat(saved.getId()).isNotNull();
        assertThat(userRoleRepository.existsByUserIdAndRoleId(user.getId(), role.getId())).isTrue();
    }
}
