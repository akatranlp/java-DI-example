import config.DIConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.MyApplication;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
        MyApplication springBean = context.getBean(MyApplication.class);
        springBean.run();
        context.close();
    }
}
