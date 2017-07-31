package com.vvygulyarniy.wowcraft.bnet.auction.client.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class Auction {
    private final int auc;
    private final int item;
    private final String owner;
    private final String ownerRealm;
    private final long bid;
    private final long buyout;
    private final int quantity;
    private final String timeLeft;

    // items
    private final int rand; // used for the random affixes
    private final long seed;
    private final int context; // origin

    // bonusLists
    private final BonusList[] bonusLists;

    // battlepets
    private final ItemModifier[] modifiers; // seen attached to 82800 (Pet Cage)
    private final int petSpeciesId;
    private final int petBreedId;
    private final int petLevel;
    private final int petQualityId;


    @JsonCreator
    public Auction(@JsonProperty("auc")          final int auc,
                   @JsonProperty("item")         final int item,
                   @JsonProperty("owner")        final String owner,
                   @JsonProperty("ownerRealm")   final String ownerRealm,
                   @JsonProperty("bid")          final long bid,
                   @JsonProperty("buyout")       final long buyout,
                   @JsonProperty("quantity")     final int quantity,
                   @JsonProperty("timeLeft")     final String timeLeft,
                   @JsonProperty("rand")         final int rand,
                   @JsonProperty("seed")         final long seed,
                   @JsonProperty("context")      final int context,
                   @JsonProperty("bonusLists")   final BonusList[] bonusLists,
                   @JsonProperty("modifiers")    final ItemModifier[] modifiers,
                   @JsonProperty("petSpeciesId") final int petSpeciesId,
                   @JsonProperty("petBreedId")   final int petBreedId,
                   @JsonProperty("petLevel")     final int petLevel,
                   @JsonProperty("petQualityId") final int petQualityId) {
        this.auc = auc;
        this.item = item;
        this.owner = owner;
        this.ownerRealm = ownerRealm;
        this.bid = bid;
        this.buyout = buyout;
        this.quantity = quantity;
        this.timeLeft = timeLeft;

        this.rand = rand;
        this.seed = seed;
        this.context = context;

        this.bonusLists = bonusLists;

        this.modifiers = modifiers;
        this.petSpeciesId = petSpeciesId;
        this.petBreedId = petBreedId;
        this.petLevel = petLevel;
        this.petQualityId = petQualityId;
    }

    public int getAuc() {
        return auc;
    }

    public int getItem() {
        return item;
    }

    public String getOwner() {
        return owner;
    }

    public String getOwnerRealm() {
        return ownerRealm;
    }

    public long getBid() {
        return bid;
    }

    public long getBuyout() {
        return buyout;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getTimeLeft() {
        return timeLeft;
    }

    public int getRand() {
        return rand;
    }

    public long getSeed() {
        return seed;
    }

    public int getContext() {
        return context;
    }

    public BonusList[] getBonusLists() {
        return bonusLists;
    }

    public ItemModifier[] getModifiers() {
        return modifiers;
    }

    public int getPetSpeciesId() {
        return petSpeciesId;
    }

    public int getPetBreedId() {
        return petBreedId;
    }

    public int getPetLevel() {
        return petLevel;
    }

    public int getPetQualityId() {
        return petQualityId;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "auc=" + auc +
                ", item=" + item +
                ", owner='" + owner + '\'' +
                ", ownerRealm='" + ownerRealm + '\'' +
                ", bid=" + bid +
                ", buyout=" + buyout +
                ", quantity=" + quantity +
                ", timeLeft='" + timeLeft + '\'' +
                ", rand=" + rand +
                ", seed=" + seed +
                ", context=" + context +
                ", bonusLists=" + Arrays.toString(bonusLists) +
                ", modifiers=" + Arrays.toString(modifiers) +
                ", petSpeciesId=" + petSpeciesId +
                ", petBreedId=" + petBreedId +
                ", petLevel=" + petLevel +
                ", petQualityId=" + petQualityId +
                '}';
    }
}
