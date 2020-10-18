package org.fps.chapter7

object SumListInFP extends App {

 def sum(xs: List[Int]): Int = xs match{
   case Nil => 0
   case xs::tail => xs + sum(tail)
 }

  println(sum(List(2,4,4)))
}

