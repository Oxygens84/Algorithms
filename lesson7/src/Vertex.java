/*
 * Created by Oxana Lobysheva on 04/06/2019.
 */


public class Vertex {

    private String label;
    private boolean isVisited;
    private boolean isDone;

    public Vertex(String label){
        this.label = label;
        isVisited = false;
        isDone = false;
    }

    public String getLabel(){
        return label;
    }

    public boolean isVisited(){
        return isVisited;
    }

    public void setVisited(boolean isVisited){
        this.isVisited = isVisited;
    }

    public boolean isDone(){
        return isDone;
    }

    public void setDone(boolean isDone){
        this.isDone = isDone;
    }
}