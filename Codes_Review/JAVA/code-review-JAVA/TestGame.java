

public class TestGame {
    public static void main(String[] args) {
        // get the fighter's name and craete an instance 
        System.out.println("enter the name of your fighter");
        String fighterName = System.console().readLine();
        Fighter newFighter = new Fighter(fighterName);

        Enemy enemy = new Enemy("Goblin");
        enemy.addAttacks(new Attack ("slash,",20));
        enemy.addAttacks(new Attack ("stab,",20));
        enemy.addAttacks(new Attack ("punch,",20));

        while(newFighter.getHealth()> 0 && enemy.getHealth()>0){
            System.out.println("your turn to choose an attack");
            newFighter.displayAttacks();
            System.out.println("Enter the number of your attacks");
            int choice  = Integer.parseInt(System.console().readLine());
            newFighter.attack(choice-1,enemy);

            if(enemy.getHealth()<=0){
                System.out.println("You won!!");
                break;
            }

            enemy.randomAttack(newFighter);
            if(newFighter.getHealth()<=0){
                System.out.println("You lost !");
                break;
            }
        }
        System.out.println("play again!");
        String again =System.console().readLine();
        if(again.equalsIgnoreCase("yes")){
            main(args);
        } else{
            System.out.println("thanks for playing ");
        }
    }
}
