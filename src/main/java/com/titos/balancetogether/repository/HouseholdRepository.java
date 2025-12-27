package com.titos.balancetogether.repository;

import com.titos.balancetogether.model.Household;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HouseholdRepository extends JpaRepository<Household, Long> {
}
