    package com.upb.upb.db.repository;

    import com.upb.upb.db.model.PruebaSensor;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;

public interface PruebaSensorRepository extends JpaRepository<PruebaSensor, Long> {


    @Query("SELECT d " +
            " FROM PruebaSensor  d " +
            " WHERE d.id = :id_bitacora")
    PruebaSensor getById(@Param("id") Long id_bitacora);
}
