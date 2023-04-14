package hh.sof3as3.PuzzleProject;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3as3.PuzzleProject.domain.User;
import hh.sof3as3.PuzzleProject.domain.UserRepository;

@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepo;
	
	@Test //tehdään uusi user
	public void createNewUser() {
		User user = new User("Tester", "test", "test@gmail.com", "TESTER");
		userRepo.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
/*	@Test //testataan haku
	public void FindByUsernameShouldReturnUser() {
		List<User> users = userRepo.findByUsername("admin");
		assertThat(users.get(0).getEmail()).isEqualTo("user@gmail.com");
	} */
	
	@Test //testataan poisto
	@Rollback(false)
	public void deleteUser() {
		User user = userRepo.findById(Long.valueOf(2)).get();
		userRepo.delete(user);
		Optional<User> deleteUser = userRepo.findById(Long.valueOf(2));
		assertThat(deleteUser).isEmpty();
	}
	
}
