package infractionService;

import com.thoughtworks.xstream.XStream;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExamenInfractionServiceApplication {

        public static void main(String[] args) {
            SpringApplication.run(ExamenInfractionServiceApplication.class, args);
        }

        @Bean
        public CommandBus commandBus() {
            return SimpleCommandBus.builder().build();
        }

        @Bean
        public XStream xStream() {
            XStream xStream = new XStream();

            xStream.allowTypesByWildcard(new String[] { "com.example.**" });
            return xStream;
        }

}
