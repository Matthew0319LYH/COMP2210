setwd("D:/@Auburn/2015Fall/JAVAII/COMP2210/hws/hw03/")
mydata = read.table("time.txt", head = TRUE)
mydata
names(mydata)[2] = "Time" #"Elapsed Time (sec)"
mydata
library(ggplot2)
g = qplot(data = mydata, x=N, y = Time, geom = c("point", "line"),
          main = "Running-time in seconds for increasing problem sizes",
          ylab = "Elapsed Time (sec)")
print(g)
