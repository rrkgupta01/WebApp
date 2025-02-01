package in.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.main.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> 

{
	User findByEmail(String email);
	

}
