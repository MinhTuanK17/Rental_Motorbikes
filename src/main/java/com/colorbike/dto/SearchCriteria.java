package com.colorbike.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SearchCriteria {

    private List<PriceRange> priceRanges = new ArrayList<>();
    private List<Integer> brandIDs = new ArrayList<>();
    private List<Integer> categoryIDs = new ArrayList<>();
    private List<Integer> demandIDs = new ArrayList<>();
    private List<String> displacements = new ArrayList<>();

    public void addPriceRange(double minPrice, double maxPrice) {
        this.priceRanges.add(new PriceRange(minPrice, maxPrice));
    }

    public void addBrandID(int brandID) {
        this.brandIDs.add(brandID);
    }

    public void addCategoryID(int categoryID) {
        this.categoryIDs.add(categoryID);
    }

    public void addDisplacement(String displacement) {
        this.displacements.add(displacement);
    }

    public void addDemandID(int demandID) {
        this.demandIDs.add(demandID);
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class PriceRange {
        private double minPrice;
        private double maxPrice;
    }
}
