package ua.sombra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ua.sombra.entity.AuthorEntity;


import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    @Query("Select a from AuthorEntity a  where a.born < 1963-01-01 order by a.born")
    List<AuthorEntity> findAuthorOlder55();
    @Query("Select a.id , b.id ,a.name , b.name from author a , book b group by a.id desc limit 1;")
    List<AuthorEntity> findAuthorWithMostCountOfBooks();

}
