package com.cmy.enumeration;

enum Signal {
    GREEN, YELLOW, RED
}


public class EnumOrigin {
	static Signal color = Signal.RED;

    public void change() {
        switch (color) {
        case RED:
            color = Signal.GREEN;
            break;
        case YELLOW:
            color = Signal.RED;
            break;
        case GREEN:
            color = Signal.YELLOW;
            break;
        }
    }
    
    public static void main(String args[]){
    	
    	System.out.println(color);
    	color = Signal.YELLOW;
    	System.out.println(color.toString());
    	System.out.println(color.ordinal()); // 1
    	System.out.println(Signal.GREEN.ordinal()); // 0
    }
}
