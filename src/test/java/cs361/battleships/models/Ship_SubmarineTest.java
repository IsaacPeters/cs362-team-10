package cs361.battleships.models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Ship_SubmarineTest {
    @Test 
    public void testPlaceSubmergedSubHorizontal() {
        Ship_Submarine ship = new Ship_Submarine(true);
        ship.place('F', 5, false);
        List<Square> occupiedSquares = ship.getOccupiedSquares();
        ArrayList<Object> expected = new ArrayList<>();
        expected.add(new Square(5, 'F'));
        expected.add(new Square(5, 'G'));
        expected.add(new Square(5, 'H'));
        expected.add(new Square(4, 'H'));
        expected.add(new SquareCommand(5, 'I', 2));
        assertEquals(expected, occupiedSquares);
    }

    @Test
    public void testPlaceBattleShipOverSubmarine() {
        boolean result;
        Board gameB = new Board();

        Ship ship = new Ship_Battleship();
        result = gameB.placeShip(ship, 2, 'A', true);
        assertTrue(result);

        Ship Submarine = new Ship_Submarine(true);
        result = gameB.placeShip(Submarine, 2, 'A', true);
        assertTrue(result);
    }

    @Test
    public void testPlaceMineSweeperShipOverSubmarine() {
        boolean result;
        Board gameB = new Board();

        Ship ship = new Ship_Minesweeper();
        result = gameB.placeShip(ship, 2, 'A', true);
        assertTrue(result);

        Ship Submarine = new Ship_Submarine(true);
        result = gameB.placeShip(Submarine, 2, 'A', true);
        assertTrue(result);
    }

    @Test
    public void testPlaceDestroyerShipOverSubmarine() {
        boolean result;
        Board gameB = new Board();

        Ship ship = new Ship_Destroyer();
        result = gameB.placeShip(ship, 2, 'A', true);
        assertTrue(result);

        Ship Submarine = new Ship_Submarine(true);
        result = gameB.placeShip(Submarine, 2, 'A', true);
        assertTrue(result);
    }

    @Test
    public void testPlaceDestroyerShipOverSubmarineSwapOrder() {
        boolean result;
        Board gameB = new Board();

        Ship Submarine = new Ship_Submarine(true);
        result = gameB.placeShip(Submarine, 2, 'A', true);
        assertTrue(result);

        Ship ship = new Ship_Destroyer();
        result = gameB.placeShip(ship, 2, 'A', true);
        assertTrue(result);
    }

    @Test
    public void testPlaceMinesweeperOverNonSubmerged() {
        boolean result;
        Board gameB = new Board();

        Ship ship = new Ship_Destroyer();
        result = gameB.placeShip(ship, 2, 'A', true);
        assertTrue(result);

        Ship Submarine = new Ship_Submarine(false);
        result = gameB.placeShip(Submarine, 2, 'A', true);
        assertFalse(result);
    }

    @Test
    public void testPlaceMinesweeperOverNonSubmergedSwapped() {
        boolean result;
        Board gameB = new Board();

        Ship Submarine = new Ship_Submarine(false);
        result = gameB.placeShip(Submarine, 2, 'A', true);
        assertTrue(result);

        Ship ship = new Ship_Destroyer();
        result = gameB.placeShip(ship, 2, 'A', true);
        assertFalse(result);

    }

    @Test
    public void testPlaceBattleshipOverNonSubmergedNub() {
        boolean result;
        Board gameB = new Board();

        Ship Submarine = new Ship_Submarine(false);
        result = gameB.placeShip(Submarine, 2, 'A', false);
        assertTrue(result);

        Ship ship = new Ship_Destroyer();
        result = gameB.placeShip(ship, 1, 'A', false);
        assertFalse(result);

    }
}
