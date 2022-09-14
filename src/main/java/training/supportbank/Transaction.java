package training.supportbank;

public class Transaction {
//    fields
    String name;
    double moneyAdded;
//    if name is in To money needs to be added
    double moneyDeducted;
//    if name is in From money needs to be deducted
    String reason;
    String date;

//    constructor
    public Transaction(String name, double moneyAdded, double moneyDeducted, String reason, String date){
        this.name = name;
        this.moneyAdded = moneyAdded;
        this.moneyDeducted = moneyDeducted;
        this.reason = reason;
        this.date = date;
    }
/*

    public void getMoneyAdded(){
        if
    }
 Transaction constructor should have methods that return each of the fields
    so if I were to do  Transaction Jon = new Transaction(Jon)
    I should be able to do Jon.getMoneyAdded() and get all the money that has been deposited
    in their account. And then use that in the Accounts class to work out
    balance = name.getMoneyAdded - name.getMoneyDeducted. For the first task "List ALl"
    need to push onto github and email it to roger
*/


}