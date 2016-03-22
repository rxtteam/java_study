package com.cmy.dp.decorator;

public class CompetitorDecoratorA extends CompetitorDecorator{
    public CompetitorDecoratorA(Competitor competitor) {  
        super(competitor);  
    }  
    public void sing()  
    {  
        this.dance();  
        super.sing();  
    }  
    private void dance()  
    {  
        System.out.println("偏偏起舞....");  
    }  
}
