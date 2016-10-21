import com.hzit.entity.Book;
import com.hzit.services.BookServices;
import com.hzit.services.impl.BookServicesImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2016/10/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(value =Starapplication.class )
public class dangdnagTest {
    @Autowired
    private BookServicesImpl bookServices;
    @Test
    public   void   testfindonebook(){
           Book b=bookServices.findbookbyid("4");
        System.out.println(b.getBookName());
    }
}
