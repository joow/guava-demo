package org.guava.demo.base

import org.scalatest.{Matchers, FlatSpec}
import com.google.common.base.Joiner

class JoinerSpec extends FlatSpec with Matchers {
  "A Joiner" should "join strings with the requested separator" in {
    val joiner = Joiner.on(", ");
    val strings = Array[AnyRef]("Hello", "ScalaTest !")
    joiner.join(strings) should be ("Hello, ScalaTest !")
  }

  it should "throw NullPointerException if one string is null" in {
    val joiner = Joiner.on(", ");
    val strings = Array[AnyRef]("Hello", "ScalaTest !", null)
    a [NullPointerException] should be thrownBy {
      joiner.join(strings)
    }
  }

  it should "skip null string when asked to do so" in {
    val joiner = Joiner.on(", ").skipNulls()
    val strings = Array[AnyRef]("Hello", "ScalaTest !")
    joiner.join(strings) should be ("Hello, ScalaTest !")
  }

  it should "replace null values with requested value" in {
    val joiner = Joiner.on(", ").useForNull("ScalaTest !")
    val strings = Array[AnyRef]("Hello", null)
    joiner.join(strings) should be ("Hello, ScalaTest !")
  }
}
