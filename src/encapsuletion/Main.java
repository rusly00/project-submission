package encapsuletion;

class Bankaccount {
    private double balance;

    public void deposit(double amount)
    {
        if(amount>0)
            balance+= amount;
    }
    public double getBalance(){
        return balance;
    }
}
public class Main{
    public static void main(String args []){
        Bankaccount acc= new Bankaccount();
        acc.deposit(50000);
        System.out.println(acc.getBalance());
    }
}