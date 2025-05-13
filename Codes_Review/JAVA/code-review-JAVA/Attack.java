public class Attack {

    private String name;
    private int damageAmount;

    public Attack(String name,int damageAmount){
        if(damageAmount<5 || damageAmount>25){
            throw new IllegalArgumentException("Damage amount must be between 5 and 25");
        }
        this.name=name;
        this.damageAmount=damageAmount;
    }

    public String getName() {
        return name;
    }


    public int getDamageAmount() {
        return damageAmount;
    }


    
}
