package kz.com.factoring.Repository;

import kz.com.factoring.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    @Query(value = "Select * from users where username=?1 AND password=?2", nativeQuery = true )
    User findUserByUsernameAndPassword(String username, String password);
}