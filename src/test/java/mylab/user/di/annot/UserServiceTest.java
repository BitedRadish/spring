package mylab.user.di.annot;



import mylab.userserivce.di.xml.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations ="classpath:mylab-user-di.xml" )
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    void userTest(){
        assertNotNull(userService);
        assertNotNull(userService.getUserRepository());
        assertEquals("mariaDB",userService.getUserRepository().getDbType());
        assertNotNull(userService.getSecurityService());
        boolean result = userService.registerUser("testUser", "테스트이름", "password123");
        assertTrue(result, "registerUser()는 true를 반환해야 합니다.");
    }
}
