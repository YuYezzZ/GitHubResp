package com.yuye.memento.whiltebox;

public class GameRole {
    private int vit;
    private int atk;
    private int def;

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
    //初始化状态方法
    public void getInit(){
        vit = 100;
        atk = 100;
        def = 100;
    }
    //打boss方法
    public void fight(){
        vit = 15;
        atk = 50;
        def = 0;
    }
    //保存方法
    public MementoAdmin setRoleStateMemento(){
        MementoAdmin mementoAdmin = new MementoAdmin();
        RoleStateMemento roleStateMemento = new RoleStateMemento(vit, atk, def);
        mementoAdmin.setRoleStateMemento(roleStateMemento);
        return mementoAdmin;
    }
    //恢复存档
    public void rollBack(MementoAdmin mementoAdmin){
        RoleStateMemento roleStateMemento = mementoAdmin.getRoleStateMemento();
        this.vit = roleStateMemento.getVit();
        this.atk = roleStateMemento.getAtk();
        this.def = roleStateMemento.getDef();
    }

    @Override
    public String toString() {
        return "GameRole{" +
                "vit=" + vit +
                ", atk=" + atk +
                ", def=" + def +
                '}';
    }
}
