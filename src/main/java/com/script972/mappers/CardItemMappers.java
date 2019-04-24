package com.script972.mappers;

import com.script972.dto.CardItemDTO;
import com.script972.dto.CardItemPutDTO;
import com.script972.entity.CardItem;

/**
 * Created by script972
 */

public class CardItemMappers {


    public static CardItem CardItemDtoToEntity(CardItemPutDTO dto) {
        CardItem entity = new CardItem();
        entity.setTitle(dto.getTitle());
        entity.setNumber(dto.getNumber());
        entity.setDiscount(dto.getDiscount());
        entity.setCurrency(dto.getCurrency());
        entity.setFacePhoto(dto.getFacePhoto());
        entity.setBackPhoto(dto.getBackPhoto());
        return entity;
    }

    public static CardItemDTO cardItemEntityToDto(CardItem entity) {
        CardItemDTO dto = new CardItemDTO();


        return dto;
    }
}
