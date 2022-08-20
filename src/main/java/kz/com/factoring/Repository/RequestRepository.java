package kz.com.factoring.Repository;

import kz.com.factoring.Entity.Request;
import kz.com.factoring.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

}