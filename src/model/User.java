package model;

public abstract class User {
   private String name;
   private String NationalCode;
   private Account account;

    public User(String name, String nationalCode,String password) {
        this.name = name;
        NationalCode = nationalCode;
        Account account=new Account(nationalCode,password);

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalCode() {
        return NationalCode;
    }

    public void setNationalCode(String nationalCode) {
        NationalCode = nationalCode;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    public boolean validation (String password){
       return this.account.validatePass(password);

    }
}


