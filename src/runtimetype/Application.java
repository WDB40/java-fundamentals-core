package runtimetype;

public class Application {
    public static void main(String[] args) {

        BankAccount account1 = new BankAccount("1234");
        BankAccount account2 = new BankAccount("5678", 500);

        doWork(account1);

    }

    static void showName(Class<?> theClass){
        System.out.println(theClass.getSimpleName());
    }

    static void doWork(Object obj){
        Class<?> c = obj.getClass();
        showName(c);
    }

}
