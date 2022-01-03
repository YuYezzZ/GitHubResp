package com.yuye.template;

public class CookBaoCai extends Cook{
    public CookBaoCai(Vegetable vegetable, Flavour flavour) {
        super(vegetable, flavour);
    }

    @Override
    public void addVegetable(Vegetable vegetable) {
        super.setVegetable(vegetable);
        vegetable.show();
    }

    @Override
    public void addFlavour(Flavour flavour) {
        super.setFlavour(flavour);
        flavour.show();
    }
}
