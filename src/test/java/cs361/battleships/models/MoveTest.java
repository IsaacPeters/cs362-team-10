package cs361.battleships.models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MoveTest {


    @Test
    public void testCaptainsQuartersSurrender() {
        boolean movetest;
        Board board = new Board();
        board.placeShip(new Ship("MINESWEEPER"), 1, 'A', true);
        board.placeShip(new Ship("BATTLESHIP"), 1, 'C', true);
        board.placeShip(new Ship("DESTROYER"), 2, 'B', true);

        var result = board.attack(1,'A');
        assertEquals(result.getResult(), AtackStatus.SUNK);

        movetest = board.moveShip(-1, true);
        assertTrue(movetest);

        assertEquals('B', board.getShips().get(2).getOccupiedSquares().get(0).getColumn());
        assertEquals(1, board.getShips().get(2).getOccupiedSquares().get(0).getRow());

    }
}
