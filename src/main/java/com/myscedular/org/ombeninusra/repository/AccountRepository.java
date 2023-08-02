package com.myscedular.org.ombeninusra.repository;

import com.myscedular.org.ombeninusra.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends JpaRepository<UserAccount,Integer> {
}
