package training.supportbank;

public class Transactions {

//        fields
    public String from;
    public String to;
    public Double amountdp;
    public String date;
    public String narrative;

//    constructor
    public Transactions(String from, String to, Double amountdp, String date, String narrative){
        this.from = from;
        this.to = to;
        this.amountdp = amountdp;
        this.date = date;
        this.narrative = narrative;
    }

    public Transactions(String accName){
        this.from = accName;
    }

    public String allTransactions(){
        return String.format("To: %s \n From: %s\n Date: %s\n Narrative: %s\n Amount: £%s", this.to, this.from, this.date,this.narrative,this.amountdp);

    }


}
