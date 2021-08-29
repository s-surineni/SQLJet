package com.greatest.sqljet

import org.springframework.stereotype.Service
import java.util.*

@Service
class NonWebService {
    fun printMessage(arguments: Array<out String?>) {
        println("Inside NonWebService Class. Received below arguments")
        Arrays.stream(arguments).forEach(System.out::println)
    }
}