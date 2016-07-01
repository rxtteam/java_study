package com.cmy.mybatis.basic;

public class Phone {
    private String countryCode;  
    private String stateCode;  
    private String number;  
    public Phone()  
    {  
    }  
    public Phone(String countryCode, String stateCode, String  
                       number)  
    {  
        this.countryCode = countryCode;  
        this.stateCode = stateCode;  
        this.number = number;  
    }  
    
    public Phone(String string)  
    {  
        if(string != null)  
        {  
            String[] parts = string.split("-");  
            if(parts.length > 0) this.countryCode = parts[0];  
            if(parts.length > 1) this.stateCode = parts[1];  
            if(parts.length > 2) this.number = parts[2];  
        }  
    }  
    
    public String getAsString()  
    {  
        return countryCode + "-" + stateCode + "-" + number;  
    }  
    
    public String toString(){
		return getAsString();
    }
}
