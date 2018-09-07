package com.blog.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String guessNumber() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{num}")
//    @ResponseBody
    public String numSelection(@PathVariable int num, Model vModel) {
        vModel.addAttribute("answer", generateRandomNum());
        vModel.addAttribute("userGuess", num);
        return "roll-results";
    }

    private int generateRandomNum(){
        Random random = new Random();
        return  random.nextInt((6 - 1) + 1) + 1;
    }
}
