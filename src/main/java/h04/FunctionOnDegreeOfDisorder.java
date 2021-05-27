package h04.function;

import java.util.Comparator;

abstract public class FunctionOnDegreeOfDisorder<T> implements ListToIntFunction<T> {
  protected final Comparator<? super T> comparator;

  public FunctionOnDegreeOfDisorder(Comparator<? super T> c){
    this.comparator=c;
  }
}
