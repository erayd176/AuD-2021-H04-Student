package h04.function;

public class ArrayDoubleToIntFunction implements DoubleToIntFunction {

  private final int[]a;

  public ArrayDoubleToIntFunction(int[] b){

    this.a = new int[b.length];

    for ( int i = 0;i<b.length;i++){
        this.a[i] = b[i];
      }

  }

  @Override
  public int apply (double x)throws IllegalArgumentException{

    if(x<0||x>1){
      throw new IllegalArgumentException();
    }

    double value = x*(this.a.length-1);

    for (int i = 0;i<a.length;i++){
      System.out.println(Math.abs(i-value));
      if(Math.abs(i-value)<=0.000001){
        return a[i];
      }
    }

    System.out.println(x);
    System.out.println(value);
    int x1 = (int) Math.floor(value);
    System.out.println(x1);
    int x2 = (int) Math.ceil(value);
    System.out.println(x2);
    double f_x1 = a[(int)x1];
    double f_x2 = a[(int)x2];

    return (int) Math.round(f_x1 + ((f_x2-f_x1)/(x2-x1))*(x-x1));
  }

}
