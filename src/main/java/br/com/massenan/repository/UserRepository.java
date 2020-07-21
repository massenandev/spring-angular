package br.com.massenan.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.massenan.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);
	
	public Iterable<User> deleteByUsername(String username);

}
