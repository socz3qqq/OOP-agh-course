package agh.ics.oop;

public class Animal {
    private MapDirection direction;
    private Vector2d position;

    public Animal(){
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }
    @Override
    public String toString() {
        return position.toString() + " " + direction.toString();
    }
    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }
    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT:
                this.direction = this.direction.next();
                break;
            case LEFT:
                this.direction = this.direction.previous();
                break;
            case FORWARD:
                Vector2d forwardPosition = this.direction.toUnitVector().add(this.position);
                if(forwardPosition.precedes(new Vector2d(4,4)) && forwardPosition.follows(new Vector2d(0,0))){
                    this.position = forwardPosition;
                }
                break;
            case BACKWARD:
                Vector2d backwardPosition = this.direction.toUnitVector().subtract(this.position);
                if(backwardPosition.precedes(new Vector2d(4,4)) && backwardPosition.follows(new Vector2d(0,0))){
                    this.position = backwardPosition;
                }
                break;
        }
    }
}
