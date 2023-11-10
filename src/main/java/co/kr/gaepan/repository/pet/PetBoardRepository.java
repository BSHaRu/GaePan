package co.kr.gaepan.repository.pet;

import co.kr.gaepan.entity.pet.PetRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetBoardRepository extends JpaRepository<PetRegisterEntity, Integer> {

}
