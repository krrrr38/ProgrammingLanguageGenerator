package com.krrrr38.programming.language.generator


object Factory {
  def create(incs: List[String],
             decs: List[String],
             nexts: List[String],
             prevs: List[String],
             puts: List[String],
             gets: List[String]
              ) = new PLGParser(incs, decs, nexts, prevs, puts, gets)

  def main(args: Array[String]): Unit = {
    val runtime = new PLGRuntime

    val hoge = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.+++++++.--------.--."
    val bfparser = create(List("+"), List("-"), List(">"), List("<"), List("."), List(","))

    runtime.exec(bfparser.parse(hoge).get) // -> hoge
  }
}