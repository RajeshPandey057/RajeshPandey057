import turtle

t = turtle.Turtle()
t.color("red")
t.left(85)
for i in range(30):
    t.forward(50)
    t.right(175)
    t.forward(50)
    t.left(150)
turtle.mainloop()
