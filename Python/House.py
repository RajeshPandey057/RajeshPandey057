from turtle import Turtle, Screen


def yellowHouse(side_length):
    wn.register_shape("brick", ((0, 0), (-0.5, -0.5), (0.5, -0.5)))
    house = Turtle('brick', visible=False)
    house.shapesize(stretch_wid=side_length, outline=5)
    house.color("yellow", wn.bgcolor())
    house.penup()

    for angle in range(360, 0, -90):
        house.setheading(angle)
        house.stamp()

    house.forward(side_length)
    house.stamp()


wn = Screen()
wn.title("Yellow House")
wn.bgcolor("blue")

yellowHouse(200)

wn.exitonclick()
