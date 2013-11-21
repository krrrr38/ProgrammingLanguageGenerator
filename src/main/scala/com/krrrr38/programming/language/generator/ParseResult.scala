package com.krrrr38.programming.language.generator

trait Evaluator {
  def eval(op: Operand)

  def inc

  def dec

  def next

  def prev

  def put

  def get
}

class PLGRuntime {
  lazy val evaluator = new PLGEvaluator

  def exec(ops: List[Operand]) = ops foreach {
    evaluator.eval(_)
  }

  class PLGEvaluator extends Evaluator {
    var memory = collection.mutable.ListBuffer.empty[Int]
    var pointer = 0

    def eval(op: Operand): Unit = op.exec(this)

    def inc: Unit = {
      if (memory.size <= pointer) {
        for (i <- 0 to pointer - memory.size + 1)
          memory += 0
      }
      memory(pointer) += 1
    }

    def dec: Unit = {
      if (memory.size <= pointer) {
        for (i <- 0 to pointer - memory.size + 1)
          memory += 0
      }
      memory(pointer) -= 1
    }

    def next: Unit = pointer += 1

    def prev: Unit = {
      pointer -= 1
      if (pointer <= 0)
        throw EvalException("Invalid Pointer Evaluation Detected : %d" format pointer)
    }

    def put: Unit = {
      if (memory.size <= pointer) {
        for (i <- 0 to pointer - memory.size + 1)
          memory += 0
      }
      print(memory(pointer).toChar)
    }

    def get: Unit = {
      if (memory.size <= pointer) {
        for (i <- 0 to pointer - memory.size + 1)
          memory += 0
      }
      memory(pointer) = readChar
    }
  }

}

case class EvalException(message: String) extends java.lang.RuntimeException(message)
