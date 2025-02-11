package org.epam;

public class Biscuit
{
    private final String biscuitName;
    private int biscuitCount;
    public static final int JAR_CAPACITY = 30;

    public Biscuit(String biscuitName,int biscuitCount){
        if(biscuitCount>30) throw new IllegalArgumentException("Jar capacity is 30");
        if(biscuitName == null || biscuitName.isEmpty()) throw new IllegalArgumentException("Coffee Name can't be empty");
        this.biscuitCount = biscuitCount;
        this.biscuitName = biscuitName;
    }

    public String getBiscuitName() {
        return this.biscuitName;
    }

    public int getBiscuitCount() {
        return this.biscuitCount;
    }

    public void takeBiscuit(int count){
        if(biscuitCount==0){
            throw new IllegalArgumentException("There are no biscuits in the jar");
        }
        if(this.biscuitCount<count) throw new IllegalArgumentException("There are less biscuits in the jar");
        this.biscuitCount-=count;
    }

    public void putBiscuit(int count){
        int afterAdding = this.getBiscuitCount()+count;
        if(afterAdding > JAR_CAPACITY) {
            throw new IllegalArgumentException("Jar capacity will exceed on adding "+count+" biscuits");
        }
        this.biscuitCount+=count;
    }
}
