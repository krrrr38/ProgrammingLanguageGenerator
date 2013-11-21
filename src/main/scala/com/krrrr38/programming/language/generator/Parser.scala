package com.krrrr38.programming.language.generator

import scala.util.parsing.combinator.RegexParsers
import scala.util.matching.Regex

class PLGParser(incs: List[String],
                decs: List[String],
                nexts: List[String],
                prevs: List[String],
                puts: List[String],
                gets: List[String]
                 ) extends RegexParsers {
  def repall = rep(all)

  def all = inc | dec | next | prev | put | get

  def inc = wrap(incs) ^^ {
    case _ => new Inc
  }

  def dec = wrap(decs) ^^ {
    case _ => new Dec
  }

  def next = wrap(nexts) ^^ {
    case _ => new Next
  }

  def prev = wrap(prevs) ^^ {
    case _ => new Prev
  }

  def put = wrap(puts) ^^ {
    case _ => new Put
  }

  def get = wrap(gets) ^^ {
    case _ => new Get
  }

  val specialChars = List('¥', '*', '+', '.', '?', '{', '}', '(', ')', '[', ']', '^', '$', '-', '|', '/')
  val converter: PartialFunction[Char, String] = {
    case c if specialChars.contains(c) => "\\" + c
    case c => c.toString
  }

  private def wrap(patterns: List[String]): Regex = {
    patterns.map(_.toCharArray.map(converter).mkString).mkString("|").r
  }

  def parse(s: String): ParseResult[List[Operand]] = parseAll(repall, s)
}
