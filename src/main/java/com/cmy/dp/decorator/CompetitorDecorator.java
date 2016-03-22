package com.cmy.dp.decorator;

public class CompetitorDecorator extends Competitor{
    private Competitor competitor;  
    
    public CompetitorDecorator(Competitor competitor)  
    {  
        this.competitor= competitor;  
    }  
    public void sing()  
    {  
        competitor.sing();  
    }  
}
