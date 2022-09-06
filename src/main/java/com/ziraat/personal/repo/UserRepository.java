package com.ziraat.personal.repo;

import com.ziraat.personal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{
}
