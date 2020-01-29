package com.romco.behavioral.cor.jason;

public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);
    void dispense(Currency currency);
}


class Dollar50Dispensor implements DispenseChain {
    private DispenseChain nextInChain;
    
    @Override
    public void setNextChain(DispenseChain nextChain) {
        nextInChain = nextChain;
    }
    
    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 50) {
            int num = currency.getAmount() / 50;
            int remainder = currency.getAmount() % 50;
            System.out.println("Dispensing " + num + " $50 notes.");
            
            if (remainder >= 0) {
                this.nextInChain.dispense(new Currency(remainder));
            }
        }
    }
}

class Dollar20Dispensor implements DispenseChain {
    private DispenseChain nextInChain;
    
    @Override
    public void setNextChain(DispenseChain nextChain) {
        nextInChain = nextChain;
    }
    
    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 20) {
            int num = currency.getAmount() / 20;
            int remainder = currency.getAmount() % 20;
            System.out.println("Dispensing " + num + " $20 notes.");
            
            if (remainder >= 0) {
                this.nextInChain.dispense(new Currency(remainder));
            }
        }
    }
}

class Dollar1Dispensor implements DispenseChain {
    private DispenseChain nextInChain;
    
    @Override
    public void setNextChain(DispenseChain nextChain) {
        nextInChain = nextChain;
    }
    
    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 1) {
            int num = currency.getAmount();
            System.out.println("Dispensing " + num + " $1 notes.");
        }
    }
}