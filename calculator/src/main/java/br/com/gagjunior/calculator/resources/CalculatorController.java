package br.com.gagjunior.calculator.resources;

import br.com.gagjunior.calculator.exceptions.UnsuportedOperationException;
import br.com.gagjunior.calculator.utils.Utils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {

    @GetMapping(value = "/sum/{numberOne}/{numberTwo}")
    public ResponseEntity<Double> sum(@PathVariable String numberOne, @PathVariable String numberTwo) {
        if (!Utils.isNumeric(numberOne) || !Utils.isNumeric(numberTwo)) {
            throw new UnsuportedOperationException("Please, set a numeric value...");
        }
        Double sum = Utils.convertToDouble(numberOne) + Utils.convertToDouble(numberTwo);
        return ResponseEntity.ok(sum);
    }
}
