package agh.ics.oop;

public class Vector2d {
    public final int x;
    public final int y;
    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(Vector2d this){
        return "(" + this.x + ", " + this.y + ")";
    }
    public boolean precedes(Vector2d other){
        return this.x <= other.x && this.y <= other.y;
    }
    public boolean follows(Vector2d other){
        return this.x >= other.x && this.y >= other.y;
    }
    public Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.x, this.y + other.y);
    }
    public Vector2d substract(Vector2d other){
        return new Vector2d(this.x - other.x, this.y - other.y);
    }
    public Vector2d upperRight(Vector2d other){
        return new Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y));
    }
    Vector2d upperLeft(Vector2d other){
        return new Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y));
    }
    public Vector2d opposite(){
        return new Vector2d(-this.x, -this.y);
    }
    public boolean equals(Object other){
        if(other == this)
            return true;
        if(!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        return this.x == that.x && this.y == that.y;
    }
    public int hashCode(){

    }
}
