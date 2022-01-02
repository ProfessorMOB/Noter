package org.bloomfield.noter.utilities;

public class userInput {
    private static int i = 1;
    private String name="";
    private String item="";
    private int spacing=0;
    private String answer=""; 
    private String title="";
    private String subtitle="";

    public userInput(String name, String item, int spacing, String answer){
        this.name=name+" "+i;
        i++;
        this.item=item;
        this.spacing=spacing;
        this.answer=answer;
    }
    public String getName(){
        return name;
    }
    public String getItem(){
        return item;
    }
    public int getSpacing(){
        return spacing;
    }
    public String getAnswer(){
        return answer;
    }
    public userInput getCurrentUserInput(){
        return this;
    }
}