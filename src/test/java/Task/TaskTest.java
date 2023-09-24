package Task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void whenSimpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertTrue(actual);
    }

    @Test
    public void whenSimpleTaskNotMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Написать");

        Assertions.assertFalse(actual);
    }

    @Test
    public void whenEpicMatches() {
        Epic Epic = new Epic(55, new String[]{"Яйцо"});
        boolean actual = Epic.matches("Яйцо");

        Assertions.assertTrue(actual);
    }

    @Test
    public void whenEpicNotMatches() {
        Epic Epic = new Epic(55, new String[]{"Яйцо"});

        boolean actual = Epic.matches("Хлеб");

        Assertions.assertFalse(actual);
    }
    @Test
    public void whenMeetingRequestInTopic() {
        Meeting Meeting = new Meeting (555, "Выкатка 3й версии приложения", "Приложение НетоБанка","Во вторник после обеда" );

        boolean actual = Meeting.matches("Выкатка 3й версии приложения");
        Assertions.assertTrue(actual);
    }
    @Test
    public void whenMeetingRequestInProject() {
        Meeting Meeting = new Meeting (555, "Выкатка 3й версии приложения", "Приложение НетоБанка","Во вторник после обеда" );

        boolean actual = Meeting.matches("Приложение НетоБанка");
        Assertions.assertTrue(actual);
    }
    @Test
    public void whenMeetingRequestNotInProjectAndTopic() {
        Meeting Meeting = new Meeting (555, "Выкатка 2й версии приложения", "Приложение БетоБанка","Во вторник после обеда" );

        boolean actual = Meeting.matches("Приложение НетоБанка" );
        Assertions.assertFalse(actual);
    }
}



