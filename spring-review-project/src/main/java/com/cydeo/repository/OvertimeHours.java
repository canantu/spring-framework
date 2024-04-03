package com.cydeo.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("overtime")
public class OvertimeHours implements HoursRepository{
    @Override
    public int getHours() {
        return 15;
    }
}
