/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 * The class for the graph vertices. Provides functionality for storing information related to that specific vertex.
 * @author Elias Nygren
 */
public class Vertex implements Comparable<Vertex>{
    private int x;
    private int y;
    private double Hx;
    private double Gx;
    private char key;
    private int index; //used by VertexMinHeap to track index, eliminates need for hashmap
    private boolean onPath;
    private boolean closed;
    private boolean opened;
    private Vertex path;
    
    /**
     * Initializes values.
     * @param x coordinate
     * @param y coordinate
     * @param key type of coordinate 
     */

    public Vertex(int x, int y, char key) {
        this.index=-1;
        this.x = x;
        this.y = y;
        this.key = key;
        this.Hx = -1;
        this.Gx = -1;
        this.onPath = false;
        this.closed = false;
        this.opened = false;
        this.path=null;
    }

    public boolean isOnPath() {
        return onPath;
    }

    public void setOnPath(boolean onPath) {
        this.onPath = onPath;
    }

    /**
     * Checks if coordinates match.
     * @param v to what this is compared.
     * @return  true if coordinates match, false otherwise.
     */
    
    
    public boolean equals(Vertex v){
        if(this.x==v.getX() && this.y==v.getY()) return true;
        return false;
    }
    
    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public double getToGoal() {
        return Hx;
    }

    public void setToGoal(double toGoal) {
        this.Hx = toGoal;
    }

    public double getDistance() {
        return Gx;
    }

    public void setDistance(double distance) {
        this.Gx = distance;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public Vertex getPath() {
        return path;
    }

    public void setPath(Vertex path) {
        this.path = path;
    }
    
    
    

    /**
     * Natural order based on the distance values.
     * Formula: distance + toGoal. Default for toGoal is -1 (ignored if deafult) 
     * @param that to what this object is compared to.
     * @return  -1, 0 or 1.
     */
    @Override
    public int compareTo(Vertex that) {
        double thisdist;
        double thatdist;
        if(that==null) return 0;
        
        thisdist = this.Hx==-1 ? this.Gx : this.Gx + this.Hx;
        thatdist = that.Hx==-1 ? that.Gx : that.Gx + that.Hx;
        

        if(thisdist < thatdist){
            return -1;
        } 
        if(thisdist == thatdist){
            return 0;            
        }
        return 1;        
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Vertex{" + "x=" + x + ", y=" + y + ", key=" + key + '}';
    }

}
