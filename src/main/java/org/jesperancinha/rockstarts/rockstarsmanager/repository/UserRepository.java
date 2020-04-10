package org.jesperancinha.rockstarts.rockstarsmanager.repository;

import org.jesperancinha.rockstarts.rockstarsmanager.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}