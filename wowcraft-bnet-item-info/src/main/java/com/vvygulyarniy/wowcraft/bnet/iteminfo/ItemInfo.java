package com.vvygulyarniy.wowcraft.bnet.iteminfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemInfo {
    private final Long id;
    private final String name;

    @JsonCreator
    public ItemInfo(@JsonProperty("id") Long id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ItemInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
