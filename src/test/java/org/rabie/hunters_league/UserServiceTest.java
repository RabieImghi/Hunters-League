package org.rabie.hunters_league;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.rabie.hunters_league.domain.User;
import org.rabie.hunters_league.domain.enums.Role;
import org.rabie.hunters_league.exceptions.UserAlreadyExistsException;
import org.rabie.hunters_league.exceptions.UserNotExistException;
import org.rabie.hunters_league.repository.UserRepository;
import org.rabie.hunters_league.service.UserService;
import org.rabie.hunters_league.service.dto.UserSearchDto;
import org.rabie.hunters_league.specification.UserSpecification;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private static PasswordEncoder passwordEncoder;



    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    static Stream<User> userGenerateOld() {
        User newUser = User.builder()
                .username("newUser123")
                .password("password")
                .role(Role.MEMBER)
                .firstName("John")
                .lastName("Doe")
                .cin("X1234567")
                .email("john.doe@example.com")
                .nationality("American")
                .joinDate(LocalDateTime.now())
                .licenseExpirationDate(LocalDateTime.now().plusYears(1))
                .build();
        return Stream.of(newUser);
    }




//    @ParameterizedTest
//    @MethodSource("userGenerateOld")
//    void testSaveUserWithUsernameExist(User user) {
//        UserSearchDto searchDto = new UserSearchDto();
//        searchDto.setUsername(user.getUsername());
//
//        when(userRepository.findOne(UserSpecification.getUsersByCriteria(searchDto)))
//                .thenReturn(Optional.of(user));
//        assertThrows(UserAlreadyExistsException.class, () -> userService.save(user));
//    }
//
//    @ParameterizedTest
//    @MethodSource("userGenerateOld")
//    void testSaveUserWithEmailExist(User user){
//        UserSearchDto searchDto = new UserSearchDto();
//        searchDto.setEmail(user.getEmail());
//        when(userRepository.findOne(UserSpecification.getUsersByCriteria(searchDto)))
//                .thenReturn(Optional.of(user));
//        assertThrows(UserNotExistException.class, () -> {
//            userService.save(user);
//        });
//    }
//    @ParameterizedTest
//    @MethodSource("userGenerateOld")
//    void testSaveUserNull(User user){
//        assertThrows(UserNotExistException.class, () -> {
//            userService.save(null);
//        });
//    }
}
