package com.kodilla.testing.shape;

import com.kodilla.testing.shape.Circle;
import com.kodilla.testing.shape.ShapeCollector;
import com.kodilla.testing.shape.Square;
import com.kodilla.testing.shape.Triangle;

import org.junit.*;

import java.util.ArrayList;

public class ShapeCollectorTestSuite{

    private static int tryCounter =0;

    @BeforeClass
    public static void beforeAllTests() {
            System.out.println("Tests beginning...");
    }

    @Before
    public void beforeEachClass() {
        tryCounter++;
        System.out.println("Starting test number: " + tryCounter);
    }

    @After
    public void atEnd(){
        System.out.println("End of test number: " + tryCounter);
    }

    //Test sprawdzający czy pobrana figura z klasy ShapeCollector jest taka sama jak wstawiona z klasy Square.
    @Test
    public void testAddSquare(){
        //Given
        ArrayList<Shape> test = new ArrayList<>();
        ShapeCollector shapeCollector = new ShapeCollector (test);
        Square square = new Square ("Square", 2.00);
        shapeCollector.addFigure(square);
        //When
        Shape testFigure = test.get(0);
        //Then
        Assert.assertEquals(square, testFigure);
    }

    //Test sprawdzający czy pobrana figura z klasy ShapeCollector jest taka sama jak wstawiona z klasy Triangle.
    @Test
    public void testAddTriangle(){
        //Given
        ArrayList<Shape> test = new ArrayList<>();
        ShapeCollector shapeCollector = new ShapeCollector (test);
        Triangle triangle = new Triangle ("Triangle", 2.00);
        shapeCollector.addFigure(triangle);
        //When
        Shape testFigure = test.get(0);
        //Then
        Assert.assertEquals(triangle, testFigure);
    }

    //Test sprawdzający czy pobrana figura z klasy ShapeCollector jest taka sama jak wstawiona z klasy Circle.
    @Test
    public void testAddCircle(){
        //Given
        ArrayList<Shape> test = new ArrayList<>();
        ShapeCollector shapeCollector = new ShapeCollector (test);
        Circle circle = new Circle ("Circle", 2.00);
        shapeCollector.addFigure(circle);
        //When
        Shape testFigure = test.get(0);
        //Then
        Assert.assertEquals(circle, testFigure);
    }

    //Test sprawdzający czy klasa ShapeCollector liczy 3 elementy po wstawieniu po jednym obiekcie z klas Circle, Square i Triangle
    @Test
    public void testQuantityFigures(){
        //Given
        ArrayList<Shape> test = new ArrayList<>();
        ShapeCollector shapeCollector = new ShapeCollector (test);
        Circle circle = new Circle ("Circle", 2.00);
        Square square = new Square ("Square", 2.50);
        Triangle triangle = new Triangle ("Triangle", 2.23);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(square);
        shapeCollector.addFigure(triangle);
        //When
        int quantityOfFigures = test.size();
        //Then
        Assert.assertEquals(3, quantityOfFigures);
    }
    //Test sprawdzający czy lista jest pusta po wstawieniu jednego obiektu Square i następnie usunięciu go
    @Test
    public void testAddSquareRemove(){
        //Given
        ArrayList<Shape> test = new ArrayList<>();
        ShapeCollector shapeCollector = new ShapeCollector (test);
        Square square = new Square ("Square", 2.50);
        shapeCollector.addFigure(square);
        shapeCollector.removeFigure(square);
        //When
        int isListEmpty = test.size();
        //Then
        Assert.assertEquals(0,isListEmpty);
    }
    //Test sprawdzający czy lista jest pusta po wstawieniu jednego obiektu Triangle i następnie usunięciu go
    @Test
    public void testAddTriangleRemove(){
        //Given
        ArrayList<Shape> test = new ArrayList<>();
        ShapeCollector shapeCollector = new ShapeCollector (test);
        Triangle triangle = new Triangle ("Triangle", 2.50);
        shapeCollector.addFigure(triangle);
        shapeCollector.removeFigure(triangle);
        //When
        int isListEmpty = test.size();
        //Then
        Assert.assertEquals(0,isListEmpty);
    }
    //Test sprawdzający czy lista jest pusta po wstawieniu jednego obiektu Circle i następnie usunięciu go
    @Test
    public void testAddCircleRemove(){
        //Given
        ArrayList<Shape> test = new ArrayList<>();
        ShapeCollector shapeCollector = new ShapeCollector (test);
        Circle circle = new Circle ("Circle", 2.50);
        shapeCollector.addFigure(circle);
        shapeCollector.removeFigure(circle);
        //When
        int isListEmpty = test.size();
        //Then
        Assert.assertEquals(0,isListEmpty);
    }
    //Test sprawdzający czy można wyświetlić wszystkie elementy listy metodą showFigures
    @Test
    public void testShowFigures(){
        //Givem
        ArrayList<Shape> test = new ArrayList<>();
        ShapeCollector shapeCollector = new ShapeCollector (test);
        Square squareOne = new Square ("Square", 2.50);
        Square squareTwo = new Square ("Square", 2.23);
        Square squareThree = new Square ("Square", 3.50);
        Triangle triangleOne = new Triangle ("Triangle", 1.98);
        Circle circleOne = new Circle ("Circle", 2.22);
        shapeCollector.addFigure(squareOne);
        shapeCollector.addFigure(squareTwo);
        shapeCollector.addFigure(squareThree);
        shapeCollector.addFigure(triangleOne);
        shapeCollector.addFigure(circleOne);
        //When
        String showAllSquares = shapeCollector.showFigures();
        int quantity = test.size();
        //Then
        Assert.assertSame(5 ,quantity);


    } //metoda powinna zwrocic stringa z opisem elementow jakie posiada
    //Test sprawdzający czy można wyświetlić dowolny element kolekcji
    @Test
    public void testGetFigures(){
        //Given
        ArrayList<Shape> test = new ArrayList<>();
        ShapeCollector shapeCollector = new ShapeCollector (test);
        Square square = new Square ("Square", 2.50);
        Triangle triangle = new Triangle ("Triangle", 2.23);
        shapeCollector.addFigure(square);
        shapeCollector.addFigure(triangle);
        //When
        Shape squareOne = shapeCollector.getFigure(0);
        Shape triangleOne = shapeCollector.getFigure(1);
        //Then
        Assert.assertEquals(square, squareOne);
        Assert.assertEquals(triangle, triangleOne);
    }
}
