"""
Turtle
"""
import turtle

# Set the speed of the drawer.
turtle.speed(1)

turtle.forward(100)

# Turtle turns 45 to the right
turtle.right(45)

turtle.forward(100)

# Goto the point (100,100)
turtle.goto(100, 100)

turtle.up()
turtle.goto(100, 200)
turtle.down()
turtle.goto(-100, 200)

turtle.setheading(50)
turtle.pencolor("red")
turtle.pensize(10)
turtle.goto(-100, -100)

# Draw a circle
turtle.circle(50)
turtle.begin_fill()
turtle.fillcolor("blue")
turtle.circle(100, steps = 5)
turtle.end_fill()

turtle.undo()

turtle.hideturtle()
turtle.showturtle()

turtle.screensize(200, 200)

turtle.reset()

turtle.done()
























