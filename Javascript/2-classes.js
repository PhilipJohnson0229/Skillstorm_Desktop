class shape extends Object
{
    //a property we need to keep track of
    color;
    //when creating a class constructor make sure to pass in the properties into this constructor parameters
    constructor(color)
    {
        super();
        this.color = color;
    }

    static someFunc()
    {
        console.log('Static method');
    }

    printColor()
    {
        console.log('Some Color');
    }
}

const newShape = new shape();
newShape.color = 'red'

shape.someFunc();

newShape.printColor();

class Rectanlge extends shape
{
    length;
    width;

    constructor(length, width, color = 'blue')
    {
            super(color);
            this.length = length;
            this.width = width;
    }
}

const newRectangle = new Rectanlge(10,5);


console.log(newRectangle);