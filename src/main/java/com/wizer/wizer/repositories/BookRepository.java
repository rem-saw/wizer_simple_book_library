package com.wizer.wizer.repositories;

import com.wizer.wizer.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author samuel.sawyerr
 */

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    boolean existsByIsbnNo(String isbn);
    Optional<Book> findByIsbnNo(String isbn);
}
