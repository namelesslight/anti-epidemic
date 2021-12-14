import com.example.antiepidemic.dao.impl.ImageDaoImpl;
import org.junit.jupiter.api.Test;

public class TestClass {
    @Test
    void Test(){
        ImageDaoImpl imageDao = new ImageDaoImpl();
        imageDao.insertImage("1","2",1);
    }
}
