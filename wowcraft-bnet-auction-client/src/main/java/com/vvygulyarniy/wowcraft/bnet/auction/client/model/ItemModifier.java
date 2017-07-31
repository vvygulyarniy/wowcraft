package com.vvygulyarniy.wowcraft.bnet.auction.client.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemModifier {
    private final int type;
    private final int value;


    @JsonCreator
    public ItemModifier(@JsonProperty("type")  final int type,
                        @JsonProperty("value") final int value) {
        this.type = type;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}
