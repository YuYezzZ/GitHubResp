package com.yuye.mediator;

public class MediatorImpl extends Mediator{
    private Tenant tenant;
    private HouseOwner houseOwner;

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    @Override
    void constract(String msg, Person person) {
        if(tenant == person) {
            System.out.println("租房者"+person.getName()+"说："+msg);
        }else {
        System.out.println("房主"+person.getName()+"说："+msg);
        }
    }
}
