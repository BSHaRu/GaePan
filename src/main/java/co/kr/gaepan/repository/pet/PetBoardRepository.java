package co.kr.gaepan.repository.pet;

import co.kr.gaepan.entity.pet.PetRegisterEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetBoardRepository extends JpaRepository<PetRegisterEntity, Integer> {

    Page<PetRegisterEntity> findAll(Pageable pageable);
    Page<PetRegisterEntity> findAllByCate(Pageable pageable, int cate);

}
