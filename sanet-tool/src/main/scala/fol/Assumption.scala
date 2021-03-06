package fol

import java.util
import java.util.ArrayList

import net.sf.tweety.lp.asp.parser.ASPParser
import net.sf.tweety.lp.asp.syntax.{Rule => TweetyRule}

case class Assumption(rule: TweetyRule) {

  override def toString: String = rule.toString

}

object Assumption {
  def apply(ruleString : String): Assumption = {
    new Assumption(ASPParser.parseRule(ruleString))
  }
}

case class AssumptionSet(rules : Assumption*) {
  def as_list : util.ArrayList[TweetyRule] = {
    val list = new util.ArrayList[TweetyRule]()
    for (a <- rules)
      list.add(a.rule)
    list
  }
}

