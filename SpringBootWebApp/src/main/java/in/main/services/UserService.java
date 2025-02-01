package in.main.services;

import in.main.entities.User;

public interface UserService {
	
	public boolean registerUser(User user);
	public User loginUser(String email, String password);

}
