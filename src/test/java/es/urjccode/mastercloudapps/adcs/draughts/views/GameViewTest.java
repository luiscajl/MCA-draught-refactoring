package es.urjccode.mastercloudapps.adcs.draughts.views;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.StartController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

@RunWith(MockitoJUnitRunner.class)
public class GameViewTest {

    @Mock
    Console console;

    @InjectMocks
    GameView gameView;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Captor
    ArgumentCaptor<Integer> numbers;

    @Captor
    ArgumentCaptor<String> letters;

    @Test
    public void testInteract() {
        StartController startController = new StartController(new Game(), new State());
        this.gameView.write(startController);
        verify(console, times(66)).write(letters.capture());
        verify(console, times(24)).write(numbers.capture());
        List<String> rows = Arrays.asList(" 12345678", "1 n n n n", "2n n n n ", "3 n n n n", "4        ", "5        ",
                "6b b b b ", "7 b b b b", "8b b b b ", " 12345678");
        assertEquals(marshallStrings(rows), marshallStrings(letters.getAllValues()));
        assertEquals(marshallNumbers(listStringToListNumber(rows)), marshallNumbers(numbers.getAllValues()));
    }

    private static String marshallStrings(List<String> listString) {
        String toReturn = "";
        for (String string : listString) {
            toReturn += string.replaceAll("\\d+", "");
        }
        return toReturn;
    }

    private static List<Integer> listStringToListNumber(List<String> rows) {
        List<Integer> listInteger = new ArrayList<>();
        for (String current : rows) {
            listInteger.add(Integer.parseInt(current.replaceAll("\\D+", "")));
        }
        return listInteger;
    }

    private static String marshallNumbers(List<Integer> numbers) {
        String string = "";
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            string += iterator.next();
        }
        return string;
    }
}