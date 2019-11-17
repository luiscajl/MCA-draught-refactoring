package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GameBlockedTest {

    @Mock
    Turn turn;

    @Mock
    Draught draught;

    @Mock
    Pawn pawn;

    @Mock
    Board board;

    @InjectMocks
    Game game;

    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGivenGameWhenWhiteDontHavePiecesThenBlocked() {
        when(turn.getColor()).thenReturn(Color.WHITE);
        when(board.getPieces(Color.WHITE)).thenReturn(new ArrayList<>());
        assertTrue(game.isBlocked());
    }

    @Test
    public void testGivenGameWhenBlackDontHavePiecesThenBlocked() {
        when(turn.getColor()).thenReturn(Color.BLACK);
        when(board.getPieces(Color.BLACK)).thenReturn(new ArrayList<>());
        assertTrue(game.isBlocked());
    }

    @Test
    public void testGivenGameWhenWhiteHavePiecesThenNotBlocked() {
        when(turn.getColor()).thenReturn(Color.WHITE);
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new Pawn(Color.WHITE));
        when(board.getPieces(Color.WHITE)).thenReturn(pieces);
        assertFalse(game.isBlocked());
    }

    @Test
    public void testGivenGameWhenBlackHavePiecesThenNotBlocked() {
        when(turn.getColor()).thenReturn(Color.BLACK);
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new Pawn(Color.BLACK));
        when(board.getPieces(Color.BLACK)).thenReturn(pieces);
        assertFalse(game.isBlocked());
    }

    @Test
    public void testGivenGameWhenWhiteOnlyPawnCantMoveThenBlocked() {
        when(turn.getColor()).thenReturn(Color.WHITE);
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new Pawn(Color.WHITE));
        when(board.getPieces(Color.WHITE)).thenReturn(pieces);
        assertFalse(game.isBlocked());
    }

    @Test
    public void testGivenGameWhenBlackOnlyPawnCantMoveThenBlocked() {
        when(turn.getColor()).thenReturn(Color.BLACK);
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new Pawn(Color.BLACK));
        when(board.getPieces(Color.BLACK)).thenReturn(pieces);
        assertFalse(game.isBlocked());
    }

    @Test
    public void testGivenGameWhenWhiteDraughtCantMoveThenBlocked() {
        when(turn.getColor()).thenReturn(Color.WHITE);
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new Draught(Color.WHITE));
        when(board.getPieces(Color.WHITE)).thenReturn(pieces);
        assertFalse(game.isBlocked());
    }

    @Test
    public void testGivenGameWhenBlackOnlyDraughtCantMoveThenBlocked() {
        when(turn.getColor()).thenReturn(Color.BLACK);
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new Draught(Color.BLACK));
        when(board.getPieces(Color.BLACK)).thenReturn(pieces);
        assertFalse(game.isBlocked());
    }

}
