$4 < 18 {
  while ($4 < 18) {
    printf $1 " " $2
    if (getline <= 0) break
    printf ", "
  }
  print ""
}

{
  print toupper($1 " " $2)
}

$4 > 20 {
  print $2, $4
}

{
  sum += $4
  count++
}


BEGIN {
  print "Студенты младше 18 лет:"
}

END {
  average = sum / count
  print "Средний возраст студентов:", average
}

