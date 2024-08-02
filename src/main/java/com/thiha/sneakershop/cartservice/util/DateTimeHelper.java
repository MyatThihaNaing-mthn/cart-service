package com.thiha.sneakershop.cartservice.util;

import java.util.Date;
import java.time.Instant;

public class DateTimeHelper {
    public static Date getUtcNow(){
        Instant instant = Instant.now();

        return Date.from(instant);
    }
}
