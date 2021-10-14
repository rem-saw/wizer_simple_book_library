package com.wizer.wizer.repositories;

import com.wizer.wizer.entities.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author samuel.sawyerr
 */

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite,Long> {
}
