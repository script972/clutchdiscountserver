package com.script972.service.impl;

import com.script972.components.CloudStorageHepler;
import com.script972.dto.CardItemPutDTO;
import com.script972.entity.CardItem;
import com.script972.dto.CardItemDTO;
import com.script972.entity.User;
import com.script972.mappers.CardItemMappers;
import com.script972.repository.CardRepository;
import com.script972.service.CardItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CardItemServiceImpl implements CardItemService {

    @Autowired
    private CardRepository repository;

    @Autowired
    private UserServiceImpl userRepository;

    @Autowired
    private CloudStorageHepler cloudStorageHelper;

    @Override
    public CardItemDTO findById(Long id) {
        CardItem card = repository.findById(id);
        if (card == null) {
            CardItemDTO result = new CardItemDTO();
            result.setCodeError(3);
            result.setDescriptionError("Card with current id not found");
            return result;
        } else
            return CardItemMappers.cardItemEntityToDto(card);
    }

    @Override
    public CardItem findByNumber(String numberCard) {
        return repository.findByNumber(numberCard);
    }

    @Override
    public List<CardItemDTO> findAll() {
        List<CardItem> cardItems = this.repository.findAll();

        List<CardItemDTO> jto = new ArrayList<>();
        for (int i = 0; i < cardItems.size(); i++) {
            jto.add(CardItemMappers.cardItemEntityToDto((cardItems.get(i))));
        }
        return jto;
    }

    @Override
    public CardItemDTO addItemCard(CardItemPutDTO itemCard) {
        CardItem card = CardItemMappers.CardItemDtoToEntity(itemCard);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User user = (User) authentication.getPrincipal();
            card.setAuther(user);
            this.repository.addItemCard(card);
        }
        CardItem addedCard = this.repository.findById(card.getId());
        if (addedCard == null) {
            CardItemDTO errorCard = new CardItemDTO();
            errorCard.setCodeError(2);
            errorCard.setDescriptionError("The Card Item was not added");
            return errorCard;
        } else {
            return CardItemMappers.cardItemEntityToDto(addedCard);
        }
    }

    @Override
    public List<CardItemDTO> findByOwnerId(Long ownerid) {
        List<CardItem> list = repository.findByOwner(userRepository.findById(ownerid));
        List<CardItemDTO> result = new ArrayList<>();
        if (list.size() == 0) {
            CardItemDTO empy = new CardItemDTO();
            empy.setCodeError(3);
            empy.setDescriptionError("Current user have not any card");
            result.add(empy);
            return result;
        }
        for (int i = 0; i < list.size(); i++) {
            result.add(CardItemMappers.cardItemEntityToDto(list.get(i)));
        }
        return result;
    }

    @Override
    public List<CardItemDTO> findMyCard() {
        List<CardItemDTO> result = new ArrayList<>();
        CardItemDTO cardError = new CardItemDTO();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User user = (User) authentication.getPrincipal();
            List<CardItem> cards = this.repository.findByOwner(user);
            if (cards.size() == 0) {
                cardError.setDescriptionError("You have not any card");
                cardError.setCodeError(3);
                result.add(cardError);
                return result;
            } else {
                for (int i = 0; i < cards.size(); i++) {
                    System.out.println("card=" + i);
                    cardError.setDescriptionError("You have not any card");
                    result.add(CardItemMappers.cardItemEntityToDto(cards.get(i)));
                }
                return result;
            }
        } else {
            cardError.setCodeError(4);
            cardError.setDescriptionError("Detect user failed");
            result.add(cardError);
        }

        return result;
    }

    @Override
    public String uploadPhotoFront(MultipartFile file) throws IOException {
        return cloudStorageHelper.uploadFile(file);
    }

    @Override
    public String uploadPhotoBack(MultipartFile file) throws IOException {
        return cloudStorageHelper.uploadFile(file);
    }

    @Override
    public CardItemDTO putItemCard(CardItemDTO itemCard) {
        CardItem card = repository.findById(itemCard.getId());
        if (card == null)
            return null;

        card.updateCardItem(itemCard);
        repository.updateItemCard(card);
        repository.updateItemCard(card);
        return findById(itemCard.getId());
    }


}
