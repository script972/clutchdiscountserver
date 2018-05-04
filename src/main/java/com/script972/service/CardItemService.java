package com.script972.service;

import com.script972.dto.CardItemPutDTO;
import com.script972.entity.CardItem;
import com.script972.dto.CardItemDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CardItemService {
    CardItemDTO findById(Long id);

    CardItem findByNumber(String numberCard);

    List<CardItemDTO> findAll();

    CardItemDTO addItemCard(CardItemPutDTO itemCard);

    List<CardItemDTO> findByOwnerId(Long ownerid);

    List<CardItemDTO> findMyCard();

    String uploadPhotoFront(MultipartFile file) throws IOException;

    String uploadPhotoBack(MultipartFile file) throws IOException;

    byte[] getFrontPhoto(String file) throws IOException;

    byte[] getBackPhoto(String file) throws IOException;
}
