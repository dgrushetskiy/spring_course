import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.specialist.java.spring.config.JpaConfig;
import ru.specialist.java.spring.dao.repository.RoleRepository;
import ru.specialist.java.spring.dao.repository.UserRepository;
import ru.specialist.java.spring.entity.Role;
import ru.specialist.java.spring.entity.User;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JpaConfig.class)
@Sql(scripts = "classpath:sql_script/Microblog.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Transactional
public class UserRoleTest {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    @Autowired
    public UserRoleTest(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Test
    void create(){
        Role role = new Role();
        role.setRoleId(3);
        role.setName("MODERATOR");
        roleRepository.save(role);

        assertEquals(3, roleRepository.count());

        User user = new User();
        user.setUsername("user2");
        user.setRoles(roleRepository.findAllById(List.of(2,3)));
        userRepository.save(user);

        assertEquals(Set.of("USER", "MODERATOR"),
                userRepository.findByUsername("user2")
                        .get()
                        .getRoles()
                        .stream()
                        .map(Role::getName)
                        .collect(Collectors.toSet()));
    }

    @Test
    void update() {
        User user = userRepository.findByUsername("user1").get();
        user.setRoles(List.of(roleRepository.findById(1).get()));

        assertEquals("ADMIN", userRepository.findById(2L)
                .get()
                .getRoles()
                .get(0)
                .getName()
        );
    }

}

