package com.yuye.template;

public abstract class  Cook {
    private Vegetable vegetable;
    private Flavour flavour;

    public void setVegetable(Vegetable vegetable) {
        this.vegetable = vegetable;
    }

    public void setFlavour(Flavour flavour) {
        this.flavour = flavour;
    }

    public Cook(Vegetable vegetable, Flavour flavour) {
        this.vegetable = vegetable;
        this.flavour = flavour;
    }

    public void cook(){
        addOil();
        fireOil();
        addVegetable(vegetable);
        addFlavour(flavour);
        fire();
    }
    //加油
    public void addOil(){
        System.out.println("加入食用油");
    }
    public void fireOil(){
        System.out.println("加热食用油");
    }
    public abstract void addVegetable(Vegetable vegetable);
    public abstract void addFlavour(Flavour flavour);
    public void fire(){
        System.out.println("翻炒蔬菜");
    }
}
