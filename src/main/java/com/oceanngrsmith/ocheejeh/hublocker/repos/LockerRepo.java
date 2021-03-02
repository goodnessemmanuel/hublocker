package com.oceanngrsmith.ocheejeh.hublocker.repos;

import com.oceanngrsmith.ocheejeh.hublocker.models.Locker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LockerRepo extends JpaRepository<Locker, Long> {
    List<Locker> findByCity();
}
