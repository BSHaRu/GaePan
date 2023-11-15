package co.kr.gaepan.mapper.admin;

import co.kr.gaepan.dto.admin.GP_AdminBoardDTO;
import co.kr.gaepan.entity.admin.GP_AdminBoardEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-15T16:40:19+0900",
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

        return gP_AdminBoardDTO;
    }

    @Override
    public GP_AdminBoardEntity toEntity(GP_AdminBoardDTO dto) {
        if ( dto == null ) {
            return null;
        }

        GP_AdminBoardEntity gP_AdminBoardEntity = new GP_AdminBoardEntity();

        return gP_AdminBoardEntity;
    }
}
