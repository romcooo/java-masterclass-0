package com.romco.behavioral.cor.jason;


public class JasonMain {
    public static void main(String[] args) {
        Dollar50Dispensor dollar50Dispensor = new Dollar50Dispensor();
        Dollar20Dispensor dollar20Dispensor = new Dollar20Dispensor();
        Dollar1Dispensor dollar1Dispensor = new Dollar1Dispensor();
        dollar50Dispensor.setNextChain(dollar20Dispensor);
        dollar20Dispensor.setNextChain(dollar1Dispensor);
        dollar50Dispensor.dispense(new Currency(143));
    }
}
