import com.example.antiepidemic.service.ImageService;
import com.example.antiepidemic.service.impl.ImageServiceImpl;
import org.junit.jupiter.api.Test;

public class TestClass {
    @Test
    void Test(){
        ImageService imageService = new ImageServiceImpl();
//        System.out.println(imageService.insertImage("图片1","路径1",1));
//        System.out.println(imageService.insertImage("图片2","路径2",1));
//        System.out.println(imageService.insertImage("图片3","路径3",1));
        System.out.println(imageService.updateImage(4,"图片5","路径6"));
//        System.out.println(imageService.deleteImage(1));
//        System.out.println(imageService.queryOneImage(2));
//        System.out.println(imageService.listAllImage());
    }
}
