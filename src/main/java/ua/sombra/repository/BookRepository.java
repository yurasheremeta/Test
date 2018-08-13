package ua.sombra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.sombra.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
