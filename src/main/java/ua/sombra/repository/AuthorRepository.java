package ua.sombra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.sombra.entity.AuthorEntity;

import java.sql.Date;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    @Query("Select a from AuthorEntity a  where a.born < 1963-01-01")
    List<AuthorEntity> findAuthorOlder55();

}
