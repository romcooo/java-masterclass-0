package com.romco.structural.decorator;

class Bird
{
    public int age;

    public String fly()
    {
        return age < 10 ? "flying" : "too old";
    }
}

class Lizard
{
    public int age;

    public String crawl()
    {
        return (age > 1) ? "crawling" : "too young";
    }
}

class Dragon
{
    private int age;
    private Bird birdPart = new Bird();
    private Lizard lizardPart = new Lizard();

    public void setAge(int age)
    {
        birdPart.age
                = lizardPart.age
                = this.age
                = age;
    }
    public String fly()
    {
        return birdPart.fly();
    }
    public String crawl()
    {
       return lizardPart.crawl();
    }
}

public class DecoratorChallenge {
    public static void main(String[] args) {
        Dragon dragon = new Dragon();
        System.out.println(dragon.crawl());
        System.out.println(dragon.fly());

        dragon.setAge(5);
        System.out.println(dragon.crawl());
        System.out.println(dragon.fly());

        dragon.setAge(12);
        System.out.println(dragon.crawl());
        System.out.println(dragon.fly());
    }
}