#!/bin/sh
exec scala "$0" "$@"
!#

/*

How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

*/

import java.util.Calendar

val cal = Calendar.getInstance()
cal.set(1901, 0, 1)
var sundaysOnFirst = 0

while (cal.get(Calendar.YEAR) < 2001) {
  if (cal.get(Calendar.DAY_OF_WEEK) == 1) sundaysOnFirst += 1
  cal.add(Calendar.MONTH, 1)
}

println(sundaysOnFirst)
