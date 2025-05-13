import java.util.ArrayList;

public class Fighter {
    private String name ;
    private int health ;
    private ArrayList<Attack> attackList ; 

    public Fighter(String name){
        this.name=name;
        this.health=100;
        this.attackList=new ArrayList<>();
        this.attackList.add(new Attack("punch", 20));
        this.attackList.add(new Attack("kick", 15));
        this.attackList.add(new Attack("tackle", 25));
    }
    
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void displayAttacks(){
        for(Attack attack : attackList ){
            System.out.println(attack.getName() + "-" + "damage" + attack.getDamageAmount());
        }
    }

    public void reduceHealth(int amount){
        this.health -= amount;
        if(this.health < 0){
            this.health = 0 ;
        }
    }

    // METHOD TO PERFORM AN ATTACK ON AN ENEMY
    public void attack(int index,Enemy enemy){
        if(index>=0&&index < attackList.size()){
            Attack chosenAttack = attackList.get(index);
            enemy.reduceHealth(chosenAttack.getDamageAmount());
            System.out.println("you used " + chosenAttack.getName() + "enemy health is " + enemy.getHealth());
        }
    }

}
