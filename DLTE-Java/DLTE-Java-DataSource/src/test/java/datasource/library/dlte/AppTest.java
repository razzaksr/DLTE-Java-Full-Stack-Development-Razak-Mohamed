package datasource.library.dlte;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


/**
 * Unit test for simple App.
 */
@ExtendWith(MockitoExtension.class)
public class AppTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    ResultSet resultSet;

    @Mock
    Services services=new Services();

    @BeforeEach
    public void assemble() throws SQLException {

        lenient().when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);

        lenient().when(preparedStatement.executeUpdate()).thenReturn(1);
    }

    @Test
    public void testReadKey(){
        Optional<Transaction> transaction1= Optional.of(new Transaction(239, 9876567L, 998723334L, 75.3, new Date("7/11/2022")));
        lenient().when(services.keyBased(239)).thenReturn(transaction1);
        assertSame(transaction1,services.keyBased(239));
    }

    @Test
    public void testInsertionCall(){
        Transaction transaction1=new Transaction(239, 9876567L, 998723334L, 75.3, new Date("7/11/2022"));
        Transaction transaction2=new Transaction(984,45672834L,11232443434L,98234.54,new Date("10/3/2021"));
        services.create(transaction1);
        verify(services,times(1)).create(transaction2);
    }

    @Test
    public void testInsertion(){
        Transaction transaction1=new Transaction(239,9876567L,998723334L,75.3,new Date("7/11/2022"));
        Transaction transaction2=new Transaction(984,45672834L,11232443434L,98234.54,new Date("10/3/2021"));
        lenient().when(services.create(transaction1)).thenReturn(transaction1);
        assertSame(transaction2,services.create(transaction1));
    }

    @Test
    public void testFetch1() throws SQLException {

        List<Transaction> testData= Stream.of(
                new Transaction(121,9876567L,8765678934L,1200.4,new Date("12/30/2020")),
                new Transaction(88,567893454L,8765678934L,6700.4,new Date("11/3/2019")),
                new Transaction(239,9876567L,998723334L,75.3,new Date("7/11/2022")),
                new Transaction(984,45672834L,11232443434L,98234.54,new Date("10/3/2021"))
        ).collect(Collectors.toList());
        lenient().when(preparedStatement.executeQuery()).thenReturn(resultSet);
        lenient().when(resultSet.next()).thenReturn(true,true,false);
        lenient().when(services.fetch()).thenReturn(testData);
        assertFalse(services.fetch().size()<3);
    }

    @Test
    public void testFetch2() throws SQLException {
        List<Transaction> testData= Stream.of(
                new Transaction(121,9876567L,8765678934L,1200.4,new Date("12/30/2020")),
                new Transaction(88,567893454L,8765678934L,6700.4,new Date("11/3/2019")),
                new Transaction(239,9876567L,998723334L,75.3,new Date("7/11/2022")),
                new Transaction(984,45672834L,11232443434L,98234.54,new Date("10/3/2021"))
        ).collect(Collectors.toList());
        lenient().when(preparedStatement.executeQuery()).thenReturn(resultSet);
        lenient().when(resultSet.next()).thenReturn(true,true,false);
        lenient().when(services.fetch()).thenReturn(testData);
        assertNull(services.fetch().get(0));
    }
}
