package com.yuye.memento.blackbox;


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
    public MementoAdmin setMemento(){
        MementoAdmin mementoAdmin = new MementoAdmin();
        RoleStateMemento roleStateMemento = new RoleStateMemento(vit, atk, def);
        mementoAdmin.setMemento(roleStateMemento);
        return mementoAdmin;
    }
    //恢复存档
    public void rollBack(MementoAdmin mementoAdmin){
        RoleStateMemento roleStateMemento = (RoleStateMemento) mementoAdmin.getMemento();
        this.vit = roleStateMemento.getVit();
        this.atk = roleStateMemento.getAtk();
        this.def = roleStateMemento.getDef();
    }
    //私有内部类
    private class RoleStateMemento implements Memento{
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

        public RoleStateMemento(int vit, int atk, int def) {
            this.vit = vit;
            this.atk = atk;
            this.def = def;
        }
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
