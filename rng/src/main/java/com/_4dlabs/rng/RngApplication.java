package com._4dlabs.rng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

@SpringBootApplication
@RestController
public class RngApplication {

    public static void main(String[] args) {
        SpringApplication.run(RngApplication.class, args);
    }

    @RequestMapping("/")
    public String index() throws UnknownHostException {
        System.out.println("[DEBUG] / request");
        return "RNG running on " + InetAddress.getLocalHost().getHostName();
    }

    @GetMapping(value = "/{how_many_bytes}")
    public byte[] rng(@PathVariable("how_many_bytes") final int bound) throws InterruptedException {
        System.out.println("[DEBUG] /rng/" + bound + " request");

        Thread.sleep(500);

        byte[] b = new byte[bound];
        new Random().nextBytes(b);

        return b;
    }
}
