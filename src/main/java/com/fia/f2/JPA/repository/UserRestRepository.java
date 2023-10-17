package com.fia.f2.JPA.repository;

import com.fia.f2.JPA.Entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(path = "repo-rest-resource")
public interface UserRestRepository extends PagingAndSortingRepository<User, Long> {
    List<User> findByRole(String role);
}
