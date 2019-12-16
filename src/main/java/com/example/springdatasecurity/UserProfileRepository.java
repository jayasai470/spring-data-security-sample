package com.example.springdatasecurity;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProfileRepository extends PagingAndSortingRepository<UserProfile, String> {

    UserProfile findOneByEmail(String email);

    @Query("{tenantId: ?#{principal.tenantId}}")
    List<UserProfile> findAllByTenantId();
}
