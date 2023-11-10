package co.kr.gaepan.mapper.admin;

import co.kr.gaepan.dto.admin.GP_AdminBoardDTO;
import co.kr.gaepan.dto.admin.GP_AdminBoardDTO.GP_AdminBoardDTOBuilder;
import co.kr.gaepan.entity.admin.GP_AdminBoardEntity;
import co.kr.gaepan.entity.admin.GP_AdminBoardEntity.GP_AdminBoardEntityBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-09T11:51:05+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class AdminBoardMapperImpl implements AdminBoardMapper {

    @Override
    public GP_AdminBoardDTO toDTO(GP_AdminBoardEntity entity) {
        if ( entity == null ) {
            return null;
        }

        GP_AdminBoardDTOBuilder gP_AdminBoardDTO = GP_AdminBoardDTO.builder();

        gP_AdminBoardDTO.b_no( entity.getB_no() );
        gP_AdminBoardDTO.b_uid( entity.getB_uid() );
        gP_AdminBoardDTO.b_title( entity.getB_title() );
        gP_AdminBoardDTO.b_content( entity.getB_content() );
        gP_AdminBoardDTO.b_group( entity.getB_group() );
        gP_AdminBoardDTO.b_cate( entity.getB_cate() );
        gP_AdminBoardDTO.b_type( entity.getB_type() );
        gP_AdminBoardDTO.b_redIP( entity.getB_redIP() );
        gP_AdminBoardDTO.b_regDate( entity.getB_regDate() );
        gP_AdminBoardDTO.thumb1( entity.getThumb1() );
        gP_AdminBoardDTO.thumb2( entity.getThumb2() );
        gP_AdminBoardDTO.thumb3( entity.getThumb3() );
        gP_AdminBoardDTO.b_hit( entity.getB_hit() );
        gP_AdminBoardDTO.b_parent( entity.getB_parent() );
        gP_AdminBoardDTO.b_comment( entity.getB_comment() );

        return gP_AdminBoardDTO.build();
    }

    @Override
    public GP_AdminBoardEntity toEntity(GP_AdminBoardDTO dto) {
        if ( dto == null ) {
            return null;
        }

        GP_AdminBoardEntityBuilder gP_AdminBoardEntity = GP_AdminBoardEntity.builder();

        gP_AdminBoardEntity.b_no( dto.getB_no() );
        gP_AdminBoardEntity.b_uid( dto.getB_uid() );
        gP_AdminBoardEntity.b_title( dto.getB_title() );
        gP_AdminBoardEntity.b_content( dto.getB_content() );
        gP_AdminBoardEntity.b_group( dto.getB_group() );
        gP_AdminBoardEntity.b_cate( dto.getB_cate() );
        gP_AdminBoardEntity.b_type( dto.getB_type() );
        gP_AdminBoardEntity.b_redIP( dto.getB_redIP() );
        gP_AdminBoardEntity.b_regDate( dto.getB_regDate() );
        gP_AdminBoardEntity.thumb1( dto.getThumb1() );
        gP_AdminBoardEntity.thumb2( dto.getThumb2() );
        gP_AdminBoardEntity.thumb3( dto.getThumb3() );
        gP_AdminBoardEntity.b_hit( dto.getB_hit() );
        gP_AdminBoardEntity.b_parent( dto.getB_parent() );
        gP_AdminBoardEntity.b_comment( dto.getB_comment() );

        return gP_AdminBoardEntity.build();
    }
}
