package com.nirajaky.springbootdemo.repository;

import com.nirajaky.springbootdemo.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {
}

/*
    In Spring Data JPA, repository interfaces are not instantiated directly.
    Instead, Spring Data JPA provides the implementation at runtime. Here’s how it works:

    - Interface Definition: You define a repository interface that extends one of the
      Spring Data repository interfaces (like JpaRepository).
    - Automatic Implementation: Spring Data JPA generates a proxy instance of the
      repository interface at runtime, providing the implementation of CRUD operations
      and any custom query methods defined in the interface.
*/
