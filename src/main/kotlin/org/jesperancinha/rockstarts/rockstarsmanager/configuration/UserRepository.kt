package org.jesperancinha.rockstarts.rockstarsmanager.configuration;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}