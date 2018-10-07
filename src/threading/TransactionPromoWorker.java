package threading;

public class TransactionPromoWorker extends TransactionWorker {

    public TransactionPromoWorker(BankAccount account, char transactionType, int amount){
        super(account, transactionType, amount);
    }

    @Override
    public void run(){
        if(transactionType == 'w'){
            account.withdrawal(amount);
        } else if(transactionType == 'd'){
            synchronized (account) {
                account.deposit(amount);
                if (account.getBalance() > 500) {
                    int bonus = (int) ((account.getBalance() - 500) * 0.01);
                    account.deposit(bonus);
                }
            }
        }
    }

}
