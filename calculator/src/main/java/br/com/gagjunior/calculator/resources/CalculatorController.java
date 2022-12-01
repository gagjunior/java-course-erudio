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

    @GetMapping(value = "/sub/{numberOne}/{numberTwo}")
    public ResponseEntity<Double> sub(@PathVariable String numberOne, @PathVariable String numberTwo) {
        if (!Utils.isNumeric(numberOne) || !Utils.isNumeric(numberTwo)) {
            throw new UnsuportedOperationException("Please, set a numeric value...");
        }
        Double sub = Utils.convertToDouble(numberOne) - Utils.convertToDouble(numberTwo);
        return ResponseEntity.ok(sub);
    }

    @GetMapping(value = "/mult/{numberOne}/{numberTwo}")
    public ResponseEntity<Double> mult(@PathVariable String numberOne, @PathVariable String numberTwo) {
        if (!Utils.isNumeric(numberOne) || !Utils.isNumeric(numberTwo)) {
            throw new UnsuportedOperationException("Please, set a numeric value...");
        }
        Double mult = Utils.convertToDouble(numberOne) * Utils.convertToDouble(numberTwo);
        return ResponseEntity.ok(mult);
    }

    @GetMapping(value = "/div/{numberOne}/{numberTwo}")
    public ResponseEntity<Double> div(@PathVariable String numberOne, @PathVariable String numberTwo) {
        if (!Utils.isNumeric(numberOne) || !Utils.isNumeric(numberTwo)) {
            throw new UnsuportedOperationException("Please, set a numeric value...");
        }
        if (Utils.convertToDouble(numberOne) <= 0 || Utils.convertToDouble(numberTwo) <= 0) {
            throw new UnsuportedOperationException("Error: divide by zero");
        }
        Double div = Utils.convertToDouble(numberOne) / Utils.convertToDouble(numberTwo);
        return ResponseEntity.ok(div);
    }

    @GetMapping(value = "/avg/{numberOne}/{numberTwo}")
    public ResponseEntity<Double> avg(@PathVariable String numberOne, @PathVariable String numberTwo) {
        if (!Utils.isNumeric(numberOne) || !Utils.isNumeric(numberTwo)) {
            throw new UnsuportedOperationException("Please, set a numeric value...");
        }

        double sum = Utils.convertToDouble(numberOne) + Utils.convertToDouble(numberTwo);
        if (sum == 0) {
            throw new UnsuportedOperationException("Enter at least one number greater than zero");
        }

        double avg = sum / 2;
        return ResponseEntity.ok(avg);
    }

    @GetMapping(value = "/sqrt/{numberOne}")
    public ResponseEntity<Double> avg(@PathVariable String numberOne) {
        if (!Utils.isNumeric(numberOne)) {
            throw new UnsuportedOperationException("Please, set a numeric value...");
        }
        double sqrt = Math.sqrt(Utils.convertToDouble(numberOne));
        return ResponseEntity.ok(sqrt);
    }
}
