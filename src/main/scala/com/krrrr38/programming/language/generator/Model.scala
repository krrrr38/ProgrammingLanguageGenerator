package com.krrrr38.programming.language.generator

sealed trait Operand {
  def exec(evaluator: Evaluator)
}

class Inc extends Operand {
  def exec(evaluator: Evaluator) = evaluator.inc
}

class Dec extends Operand {
  def exec(evaluator: Evaluator) = evaluator.dec
}

class Next extends Operand {
  def exec(evaluator: Evaluator) = evaluator.next
}

class Prev extends Operand {
  def exec(evaluator: Evaluator) = evaluator.prev
}

class Put extends Operand {
  def exec(evaluator: Evaluator) = evaluator.put
}

class Get extends Operand {
  def exec(evaluator: Evaluator) = evaluator.get
}
