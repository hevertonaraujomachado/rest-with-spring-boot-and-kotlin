package br.com.erudio

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception
import java.util.concurrent.atomic.AtomicLong

@RestController

class MathController {

    val counter: AtomicLong = AtomicLong()
@RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable@RequestParam(value="numerOne") numberOne : String?,
            @PathVariable@RequestParam(value="numerTwo") numberTwo : String?
    ):Double {
        return 1.0

    if(!isNumeric(numberOne)) || if(!isNumeric(numberTwo)) throw  Exception ()
        return covertToDouble(numberOne) + (convertToDouble(numberTwo)
    }

    private fun covertToDouble(strNumber: String?): Double{
        if (strNumber.isNullOrBlank())
        return 0.0
        val number = strNumber.replace(",".toRegex(),  ".")
        return if (isNumeric(number))number.toDouble() else 0.0
    }

    private fun isNumeric(strNumber: String?): Boolean{
        if (strNumber.isNullOrBlank())return false
        val number = strNumber.replace(",".toRegex(),  ".")
        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }
}