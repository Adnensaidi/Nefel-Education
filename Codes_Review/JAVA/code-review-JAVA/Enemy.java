import java.util.ArrayList ;
import java.util.Random;
public class Enemy {
   
    private String name ;
    private int health ;
    private ArrayList<Attack> attackList ;  
    
    public Enemy(String name){
        this.name=name;
        this.health=100;
        this.attackList=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void addAttacks(Attack attack){
        attackList.add(attack);
    }

    public void reduceHealth(int amount){
        this.health -= amount;
        if(this.health < 0){
            this.health = 0 ;
        }
    }

    public void randomAttack(Fighter fighter){
        if(!attackList.isEmpty()){
            Random random = new Random();
            int index = random.nextInt(attackList.size());
            Attack chosenAttack = attackList.get(index);
            fighter.reduceHealth(chosenAttack.getDamageAmount());
            System.out.println("Enemy used"+chosenAttack.getName()+"your health is "+fighter.getHealth());
        }
    }

}
