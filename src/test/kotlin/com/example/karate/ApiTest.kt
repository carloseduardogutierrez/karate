package com.example.karate

import com.intuit.karate.junit5.Karate

class ApiTest {

    @Karate.Test
    fun testGetMethod(): Karate {
        return Karate.run("getMethod").relativeTo(javaClass)
    }

    @Karate.Test
    fun testGetMethod2(): Karate {
        return Karate.run("getMethod2").relativeTo(javaClass)
    }

    /* uncomment if you want to run all the test
    @Karate.Test
    fun testAll(): Karate? {
        return Karate.run().relativeTo(javaClass)
    }
    */

}