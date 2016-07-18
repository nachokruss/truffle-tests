example <- function(x)
{
  n <- length(x)
  for (k in n:2)
  {
    i <- 1       
    while (i < k)
    {
      if (x[i] > x[i+1])
      {
        temp <- x[i+1]
        x[i+1] <- x[i]
        x[i] <- temp
      }
      i <- i+1
    }
  }
  x
}

set.seed(1)
for (i in 0:1000){
  x <-sample(0:100000,1000)
  x = example(x)
}
