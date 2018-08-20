package com.test.visitor;

//单个单子的接口（相当于Element）
public interface Bill {

  void accept(Viewer viewer);

}
