package ua.sombra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.sombra.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

        @Query("select b.genre , count(b.genre) from BookEntity b where b.genre = :genre")
        BookEntity findCountByGenre(@Param("genre") String genre);
        @Query("Select a.id, a.name , b.name from author a , book b  group by a.id  Having count(a.id) > 1 ;")
        BookEntity findBook();

}