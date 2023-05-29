BEGIN {
  print "Студенты младше 18 лет:"
}

$4 < 18 {
  while ($4 < 18) {
    printf $1 " " $2 " " $4
    if (getline <= 0) break
  }
  print ""
}

