package pl.coderslab.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.ServletContext;

import java.io.*;
import java.net.http.HttpResponse;
import java.util.Random;
import java.util.Scanner;

@Controller
public class HelloController {
    Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/workers")
    public String workersAction(Model model){

        Random random = new Random();
        int person = random.nextInt(15) + 1;
        //FileSystemResource resource = new FileSystemResource("src/main/resources/Workers.txt");
        //File file = resource.getFile();
        File file = new File("src/main/resources/Workers.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                log.info("new line");
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                log.info(parts[0]);
                log.info(parts[1]);
                if (Integer.parseInt(parts[0]) == person){
                    model.addAttribute("person", parts[1]);
                    return "workers";
                }
            }
            log.info("starting");

            log.info("File ok");
        }catch (IOException ex){
            log.debug("Problem with access to file");
        }
        return "workers";
    }
}
