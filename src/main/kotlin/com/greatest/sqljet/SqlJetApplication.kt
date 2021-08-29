package com.greatest.sqljet

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class SqlJetApplication: CommandLineRunner {

    @Autowired
    var service: NonWebService? = null

    override fun run(vararg args: String?) {
        service?.printMessage(args)
    }

    companion object {
        @JvmStatic
        fun  main(args: Array<String>) {
            runApplication<SqlJetApplication>(*args)
        }
    }


}


