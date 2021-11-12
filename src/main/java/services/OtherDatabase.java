package services;

import org.springframework.stereotype.Service;

@Service
public class OtherDatabase implements Database{
    @Override
    public String getOne() {
        return this.toString();
    }
}
