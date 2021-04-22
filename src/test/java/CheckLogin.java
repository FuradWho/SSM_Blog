import com.spoof.domain.Blogger;
import com.spoof.service.BloggerService;
import com.spoof.service.Impl.BloggerServiceImpl;
import org.junit.Test;

public class CheckLogin {

    @Test
    public void checkLogin(){
        BloggerService bloggerService = new BloggerServiceImpl();
        Blogger blogger= bloggerService.getBloggerInfo();
        System.out.println(blogger);
    }
}
