package com.vvygulyarniy.wowcraft.bnet.auction.client.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BonusList {
    private final int bonusListId;

    @JsonCreator
    public BonusList(@JsonProperty("bonusListId") final int bonusListId) {
        this.bonusListId = bonusListId;
    }

    public int getBonusListId() {
        return bonusListId;
    }
}
