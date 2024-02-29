package org.ccd.jdbc.repository;

import org.ccd.jdbc.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestJPARepository extends JpaRepository<Test, Long> {

}
