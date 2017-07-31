package com.vvygulyarniy.wowcraft.bnet.auction.client.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Realm {
    private final String name;
    private final String slug;

    @JsonCreator
    public Realm(@JsonProperty("name") String name, @JsonProperty("slug") String slug) {
        this.name = name;
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }
}
