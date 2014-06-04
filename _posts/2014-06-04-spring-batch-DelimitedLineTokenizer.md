---
layout: post
title: Spring Batch, A glimpse at <code>DelimitedLineTokenizer</code>
tags : [Spring, Batch, Spring Batch, LineTokenizer, DelimitedLineTokenizer]
---

In this post we are going to play around with the <code>DelimitedLineTokenizer</code> class to
spotlight some interesting features.

{% include spring-batch/tony-parker-context.md %}

## Glimpse

#### Get value by index position (<code>getValueByIndexTest()</code>)
In its most basic form <code>DelimitedLineTokenizer</code> gives access to the values through their **position indexes**. 

#### Get value by name (<code>getValueByNameTest()</code>)
If you want to access values by their **names**, you can do so in providing names to the columns.

#### Filter the fields (<code>getIncludedFieldsTest()</code>)  
Now i have a need only for the first (name) and the last (average point per game) and i want to access value by name. One solution would be to declare 24 names for using only two.
Thanks to <code>DelimitedLineTokenizer</code>, we can specify the fields to include.

So in our case we just have to :
 
 * declare the names (<code>tokenizer.setNames(new String[] { "player", "pts" });</code>)
 * declare the fields to include (<code>tokenizer.setIncludedFields(new int[] { 0, 23 });</code>) 
 
Note that the number of fields is 2.

The interest of the <code>includedFields</code> attribut is manifest when handling lines that looks like that

	field01;;;field02;;;;;;;;;;;;;;;field03

## Unit test class

{% highlight java %}
{% include spring-batch/one-step/src/test/java/gnavarro77/blog/spring/batch/DelimitedLineTokenizerTest.java %}
{% endhighlight %}