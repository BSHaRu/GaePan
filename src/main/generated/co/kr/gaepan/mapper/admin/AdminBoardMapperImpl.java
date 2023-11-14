package co.kr.gaepan.mapper.admin;

import co.kr.gaepan.dto.admin.GP_AdminBoardDTO;
import co.kr.gaepan.entity.admin.GP_AdminBoardEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-14T13:59:50+0900",

    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class AdminBoardMapperImpl implements AdminBoardMapper {

    @Override
    public GP_AdminBoardDTO toDTO(GP_AdminBoardEntity entity) {
        if ( entity == null ) {
            return null;
        }

        GP_AdminBoardDTO gP_AdminBoardDTO = new GP_AdminBoardDTO();


    @Override
    public GP_AdminBoardEntity toEntity(GP_AdminBoardDTO dto) {
        if ( dto == null ) {
            return null;
        }
        GP_AdminBoardEntity gP_AdminBoardEntity = new GP_AdminBoardEntity();
        GP_AdminBoardEntityBuilder gP_AdminBoardEntity = GP_AdminBoardEntity.builder();
      
        gP_AdminBoardEntity.bno( dto.getBno() );
        gP_AdminBoardEntity.uid( dto.getUid() );
        gP_AdminBoardEntity.title( dto.getTitle() );
        gP_AdminBoardEntity.content( dto.getContent() );
        gP_AdminBoardEntity.group( dto.getGroup() );
        gP_AdminBoardEntity.cate( dto.getCate() );
        gP_AdminBoardEntity.type( dto.getType() );
        gP_AdminBoardEntity.regIP( dto.getRegIP() );
        gP_AdminBoardEntity.regDate( dto.getRegDate() );
        gP_AdminBoardEntity.hit( dto.getHit() );
        gP_AdminBoardEntity.parent( dto.getParent() );
        gP_AdminBoardEntity.comment( dto.getComment() );
      
        return gP_AdminBoardEntity;
    }
}
