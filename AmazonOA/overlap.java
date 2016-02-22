class{
  double x;
  double y;
  public Node(double x,double y){
    this.x = x;
    this.y = y;
  }
}

public class OverLap{
  public static boolean check(Node topLeftA,Node topLeftB,Node bottomRA,Node bottomRB){
    if(bottomRA.y<=topLeftB.y||bottomRB.y<=topLeftA.y){
      return false;
    }
    if(topLeftA.x<=bottomRB.x||topLeftB.x<=bottomRA.x){
      return false;
    }
    return true;
  }
}
