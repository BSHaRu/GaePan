package co.kr.gaepan.repository.admin;

import co.kr.gaepan.entity.admin.GP_AdminBoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminBoardRepository extends JpaRepository<GP_AdminBoardEntity, Integer> {
    /*Page<GP_AdminBoardEntity> findAll(Pageable pageable);

    Page<GP_AdminBoardEntity> findByGPAdminBoardEntity_CateOrderByRdateDesc(Pageable pageable, int cate);*/
}
