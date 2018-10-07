package threading;

public class TransactionWorker implements Runnable{

    protected BankAccount account;
    protected char transactionType;
    protected int amount;

    public TransactionWorker(BankAccount account, char transactionType, int amount){
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public void run(){
        if (transactionType == 'w'){
            account.withdrawal(amount);
        }else if(transactionType == 'd'){
            account.deposit(amount);
        }
    }

}
