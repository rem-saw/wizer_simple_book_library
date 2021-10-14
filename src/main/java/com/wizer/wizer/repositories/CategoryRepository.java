package com.wizer.wizer.repositories;

import com.wizer.wizer.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author samuel.sawyerr
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
