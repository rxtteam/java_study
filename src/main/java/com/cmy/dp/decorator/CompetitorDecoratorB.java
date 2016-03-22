package com.cmy.dp.decorator;

public class CompetitorDecoratorB extends CompetitorDecorator{
    public CompetitorDecoratorB(Competitor competitor) {  
        super(competitor);  
    }  
    public void sing()  
    {  
        this.playMusic();  
        super.sing();  
    }  
    private void playMusic()  
    {  
        System.out.println("播放背景音乐......");  
    }  
}
