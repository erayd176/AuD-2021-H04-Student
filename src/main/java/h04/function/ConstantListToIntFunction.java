package h04.function;

import java.util.List;

public class ConstantListToIntFunction<T> implements ListToIntFunction<T>{

  private final int a;

  public ConstantListToIntFunction(int a){
    this.a=a;
  }

  @Override
  public int apply(List list) throws NullPointerException {
    if(list==null)
      throw new NullPointerException();

    return this.a;
  }
}
