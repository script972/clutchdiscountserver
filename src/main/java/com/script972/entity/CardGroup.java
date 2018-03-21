package com.script972.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "CardGroup")
public class CardGroup {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @JsonIgnore
    @OneToMany(mappedBy = "cardGroup")
    private Collection<CardItem> cardItems;

    public CardGroup(String title, Collection<CardItem> cardItems) {
        this.title = title;
        this.cardItems = cardItems;
    }

    public CardGroup() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<CardItem> getCardItems() {
        return cardItems;
    }

    public void setCardItems(Collection<CardItem> cardItems) {
        this.cardItems = cardItems;
    }
}
