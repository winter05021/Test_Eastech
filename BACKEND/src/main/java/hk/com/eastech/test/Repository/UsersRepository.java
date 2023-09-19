package hk.com.eastech.test.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import hk.com.eastech.test.Entity.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
}
